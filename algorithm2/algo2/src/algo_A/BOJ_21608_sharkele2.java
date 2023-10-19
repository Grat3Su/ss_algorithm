package algo_A;

import java.io.*;
import java.util.*;

class BOJ_21608_sharkele2{
    static int N;
    static int[][] map;//맵
    static int[] count;//앉힐 순서 배열
    static boolean[][] visit;//방문 배열
    static List<List<Integer>> adjlist = new ArrayList<>();
    
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int num = N*N;//최대 학생 수
        count = new int[num];
        map = new int[N][N];
        visit = new boolean[N][N];
        
        for(int i = 0; i<num; i++){
            adjlist.add(new ArrayList<>());
        }

        for(int i = 0; i<num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            count[i]  = Integer.parseInt(st.nextToken())-1;//현재 학생 : 순서 배열에 넣어야함
            for(int j = 0; j<4; j++){
                adjlist.get(count[i]).add(Integer.parseInt(st.nextToken())-1);//걔가 좋아하는 학생 -> 단방향
            }
        }

        Node[] students = new Node[num];
        students[count[0]] = new Node(1, 1, 0, 0);

        //시작
        for(int t = 1; t<num; t++){
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(map[i][j] == 0){//빈칸일때
                    int fav = like(i,j,count[t]);
                    if(fav > 0){
                        students[count[0]] = new Node(i, j, 0, emptySeat(i, j));
                    }
                }
                
            }
        }
    }
}



//빈자리
static int emptySeat(int x, int y){
    int cnt = 0;
    for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        
        if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
        
        // 빈칸이면 count 증가
        if (map[nx][ny] == 0) {
            cnt++;
        }
    }
    return cnt;
}

//좋아하는 학생
    static int like(int x,int y, int root){
        int cnt = 0;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
            
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
				continue;
			}
			// 인접한 학생이 좋아하는 학생에 포함되면 count 증가
            for(int i = 0; i<4; i++){
                if(map[nx][ny] == adjlist.get(root).get(i)){//좋아하는 사람일 때
                    cnt++;
                }
            }
		}
		return cnt;
    }

    static class Node{
        int x, y, sum, empty;

        public Node(int x, int y, int sum, int empty)
        {
            this.x = x;
            this.y = y;
            this.sum = sum;
            this.empty = empty;
        }
    }
}