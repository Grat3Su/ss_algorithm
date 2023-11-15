package algooo;

import java.io.*;
import java.util.*;

/*
3 90 10
100 90 80


-> 2
 */

public class BOJ_1205_grade2 {
    static int N, S, P, ans;
    static int[] scoreBoard;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        scoreBoard = new int[P];
        st = new StringTokenizer(br.readLine());
        Arrays.fill(scoreBoard, -1);//-1로 랭크 초기화 : 내 점수가 0점인 경우도 있다.
        for(int i = 0; i<N; i++) {
        	scoreBoard[i] = Integer.parseInt(st.nextToken());
        }
        
        
        //입력과 동시에 체크
        if (N > 0) {//현재 랭크에 한명이라도 있다
            int rank = 1;
            //랭커인가 체크?
            boolean ranker = false;
            //같은 점수가 있는지 확인
            int sameScore = 1;
            
            // scoreBoard[0] = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N; i++) {
                if (i > 0) {
                    if (scoreBoard[i] != scoreBoard[i - 1]) {
                        rank += sameScore;//점수가 같은 사람 더해서 현재 점수 얻기
                        sameScore = 1;//다시 되돌리기
                    } else {
                        sameScore++;//같은 점수인 사람 체크
                    }
                }

                if (S == scoreBoard[i]) {
                    ranker = true;//랭커다
                    ans = rank;//현재 랭크가 내 점수
                } else if (!ranker && S > scoreBoard[i]) {//같은 점수인 사람은 없는데 현재 읽는 사람이 점수가 작다
                    ranker = true;//랭커 확인
                    ans = rank;//현재 랭크가 내 랭크
                }
            }

            if (scoreBoard[P - 1] != -1 && (scoreBoard[P - 1] >= S || !ranker)) {//마지막 랭킹까지 사람이 있고 마지막 점수가 나보다 크거나 같고 랭커가 아니면
                System.out.println(-1);//-1 출력
            } else if (ans != 0)//현재 랭킹 없음
                System.out.println(ans);//현재 랭크 출력
            else if (rank != P) {//랭크가 끝이 아니다?
                System.out.println(rank + 1);//+1
            }

        } else//나 하나만 있다
            System.out.println(1);
    }
}