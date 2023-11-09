package algooo;


import java.io.*;
import java.util.*;

/*
3 90 10
100 90 80


-> 2
 */

public class BOJ_1205_grade {
    static int N, S, P;
    static int[] scoreBoard;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        if (N > 0) {
            int rank = 1;
            boolean ranker = false;
            st = new StringTokenizer(br.readLine());
            scoreBoard = new int[P];
            scoreBoard[0] = Integer.parseInt(st.nextToken());
            for (int i = 1; i < P; i++) {
                scoreBoard[i] = Integer.parseInt(st.nextToken());

                if (scoreBoard[i] != scoreBoard[i - 1])
                    rank++;

                if (S >= scoreBoard[i]) {
                    ranker = true;
                    break;
                }
            }
            if (!ranker)
                System.out.println(-1);
            else
                System.out.println(rank);
        } else
            System.out.println(1);
    }
}