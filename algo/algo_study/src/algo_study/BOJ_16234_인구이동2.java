package algo_study;
/*
N L R
map
2 20 50
50 30
20 40
(연합의 인구수) / (연합을 이루고 있는 칸의 개수)
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234_인구이동2 {
    static int N, R, L;// R명 이상 L명 이하
    static int ans;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        visit = new boolean[N][N];
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int date = 0;
        ;
        // 인구 이동 일수 체크

        System.out.println(date);

    }

    static boolean dfs(Coord v, int union, int total, boolean move) {

        visit[v.x][v.y] = true;

        for (int i = 0; i < 4; i++) {
            int x = v.x+dx[i];
            int y = v.x+dy[i];
            if (x < 0 || x >= N || y < 0 || y >= N|| visit[x][y])
                continue;
            
            map[x][y]

            if (map[x][y]) {
                
            }
            
        }
        map[v.x][v.y] = total/union;
        return move;// 만약 움직임이 있으면 true, 아니면 false
    }

    static class Coord {
        int x, y;
    }
}