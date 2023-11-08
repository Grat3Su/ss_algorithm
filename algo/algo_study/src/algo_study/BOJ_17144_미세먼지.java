package algo_study;

import java.io.*;
import java.util.*;
/*
R, C, T (6 ≤ R, C ≤ 50, 1 ≤ T ≤ 1,000)
Ar,c (-1 ≤ Ar,c ≤ 1,000)
7 8 1
0 0 0 0 0 0 0 9
0 0 0 0 3 0 0 8
-1 0 5 0 0 0 22 0
-1 8 0 0 0 0 0 0
0 0 0 0 0 10 43 0
0 0 5 0 15 0 0 0
0 0 40 0 0 0 20 0

-> 188
 */

public class BOJ_17144_미세먼지 {
    static int R, C, T;
    static int[][] map;

    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    static List<Coord> dustList;// 미세 먼지 위치 리스트

    static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }

    // 미세먼지 확산
    static void spread() {
        for (int i = 0; i < dustList.size(); i++) {
            int x = dustList.get(i).x;
            int y = dustList.get(i).y;
            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];

            }
        }
    }

    // 공기 청정기 작동

    static class Coord {
        int x, y, n;

        public Coord(int x, int y, int n) {
            this.x = x;
            this.y = y;
            this.n = n;
        }

    }

}
