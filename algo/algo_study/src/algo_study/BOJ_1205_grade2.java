package algo_study;

import java.io.*;
import java.util.*;

public class BOJ_1205_grade2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if (N == 0) {
            System.out.println(1);
            return;
        }

        st = new StringTokenizer(br.readLine());
        Integer[] scores = new Integer[N];

        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        int rank = 1;
        int sameScore = 1;
        boolean ranker = false;

        Arrays.sort(scores, Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            if (i > 0 && scores[i] != scores[i - 1]) {
                rank += sameScore;
                sameScore = 1;
            } else {
                sameScore++;
            }

            if (S >= scores[i]) {
                ranker = true;
                break;
            }
        }

        if (ranker || N < P) {
            if (rank <= P) {
                System.out.println(rank);
            } else {
                System.out.println(-1);
            }
        } else {
            System.out.println(-1);
        }
    }
}
