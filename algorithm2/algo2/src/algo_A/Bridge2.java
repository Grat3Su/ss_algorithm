package algo_A;

import java.io.*;
import java.util.*;

public class Bridge2 {
    static int N, M, ans;
    static int[][] map;
    static boolean[][] visit;
    static int[][] adjMatrix = new int[7][7];
    static int[] parent;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)->o1.weight - o2.weight);

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 1;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(!visit[i][j]&&map[i][j]==1){
                    bfs(new int[]{i,j},cnt);
                    cnt++;
                }
            }
        }

        parent = new int[cnt];
        visit = new boolean[N][M];

        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(map[i][j]!=0){
                    for(int d = 0; d<4; d++){
                        makeBridge(new int[]{i,j}, map[i][j], 0, d);
                    }
                }
            }
        }

        for(int i = 0; i<cnt; i++){
            parent[i] = i;
        }

        while(!pq.isEmpty()){
            Node n = pq.poll();
            if(find(n.to)!=find(n.from)){
                union(n.to, n.from);
                ans+=n.weight;
            }
        }

        for(int i = 1; i<cnt; i++){
            for(int j = i+1; j<cnt; j++){
                if(find(i)!=find(j))
                    ans = 0;
            }
        }

        System.out.println(ans==0?-1:ans);
    }

    static int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static boolean union(int a, int b){
        int pa = parent[a];
        int pb = parent[b];

        if(pa==pb)return false;

        if(pa<pb) parent[pa] = pb;
        else parent[pb] = pa;

        return true;
    }

    static void bfs(int[] pos, int cnt){
        Queue<int[]>q = new ArrayDeque<>();
        q.offer(new int[]{pos[0],pos[1]});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            visit[x][y] = true;
            map[x][y] = cnt;

            for(int i = 0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx<0||nx>=N||ny<0||ny>=M||map[nx][ny]==0||visit[nx][ny])continue;
                q.offer(new int[]{nx, ny});
            }
        }
    }

    static void makeBridge(int[] pos, int root, int cnt, int dir){
        int x = pos[0] + dx[dir];
        int y = pos[1] + dy[dir];

        if(x<0||x>=N||y<0||y>=M||map[x][y] == root)return;

        if(map[x][y]!=0){//시작점이 아닌 어디든 도착
            adjMatrix[root][map[x][y]] = cnt;
            if(cnt>1){//길이는 1 dltkddldjdigka
                pq.offer(new Node(root, map[x][y], cnt));//to from weight
                return;
            }
        }

        //map[][] == 0이면 움직임
        makeBridge(new int[]{x,y}, root, cnt+1, dir);
    }


    static class Node{
        int to, from, weight;

        public Node(int to, int from, int weight) {
            this.to = to;
            this.from = from;
            this.weight = weight;
        }        
    }
}
