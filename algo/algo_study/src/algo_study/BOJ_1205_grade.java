package algo_study;

import java.io.*;
import java.util.*;

/*
3 90 10
100 90 80


-> 2
 */

public class BOJ_1205_grade {
    static int N, S, P, ans;
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
            int sameScore = 1;
            st = new StringTokenizer(br.readLine());
            scoreBoard = new int[P];
            for (int i = 0; i < N; i++) {
                scoreBoard[i] = Integer.parseInt(st.nextToken());
            }
            // Arrays.fill(scoreBoard, -1);
            // Arrays.sort(scoreBoard);
            // scoreBoard[0] = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N; i++) {
                // scoreBoard[i] = Integer.parseInt(st.nextToken());
                if (i > 0) {
                    if (scoreBoard[i] != scoreBoard[i - 1]) {
                        rank += sameScore;
                        sameScore = 1;
                    } else {
                        sameScore++;
                    }
                }

                if (S == scoreBoard[i]) {
                    ranker = true;
                    ans = rank;
                } else if (!ranker && S > scoreBoard[i]) {
                    ranker = true;
                    ans = rank;
                }
            }

            if (scoreBoard[P - 1] != -1 && (scoreBoard[P - 1] >= S || !ranker)) {
                System.out.println(-1);
            } else if (ans != 0)
                System.out.println(ans);
            else if (rank != P) {
                System.out.println(rank + 1);
            }

        } else
            System.out.println(1);
    }
}