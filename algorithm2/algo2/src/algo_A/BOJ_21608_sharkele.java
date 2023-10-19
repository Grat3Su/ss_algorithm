package algo_A;

import java.io.*;
import java.util.*;
//폐기 사유
//빈칸 체크는 되는데 그 칸에서 얼마나 많이 인접하냐는 안나올듯?

class BOJ_21608_sharkele{
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
        
        //첫번째 학생 위치
        List<Node>list = new ArrayList<>();
        map[1][1] = count[0];
        list.add(new Node(1,1));

        //리스트 돌려가면서 자리 정하기
        for(int i = 1; i<num; i++){
            for(int j = list.size()-1; j>0; j--){                    
                
                int x = list.get(j).x;
                int y = list.get(j).y;
                
                int cnt = 0;
                Node next = new Node(-1, -1);
                for(int k = 0; k<4; k++){
                    int blank = 0;//비어있는 체크
                    if(map[x][y] == adjlist.get(i).get(k)){//좋아하는 사람이냐
                        int curBlank = 0;
                        for(int d = 0; d<4; d++){//그 주변이 비어있느냐
                            int nx = x+dx[d];
                            int ny = y+dy[d];
                            if(nx <0||nx>=N||ny<0||ny>=N||map[nx][ny]!=0) continue;
                            curBlank++;
                        }//다 셌다
                        if(curBlank == blank){//누가 

                        }else if(curBlank >blank){
                            blank = curBlank;

                        }
                    }
                }
                

                }

            }
        }
    

// 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
// 2. 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
// 3. 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
    static void favorite(Node cur, Node max, int root, int cnt){//현재 위치 가장 높은 값..은 어디 저장하지?
        for(int d = 0; d<4; d++){
            int nx = cur.x+dx[d];
            int ny = cur.x+dy[d];
            if(nx <0||nx>=N||ny<0||ny>=N) continue;

            for(int i = 0; i<4; i++){
                if(map[nx][ny] == adjlist.get(root).get(i)){//좋아하는 사람일 때
                    cnt += 1;
                }
            }
        }
    }

    static class Node{
        int x, y;

        public Node(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
}