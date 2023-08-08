package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_1158_요세푸스_배열 {
	/*	데이터셋
	 * 	7 3
	 * 	사람 수 N과 제거할 번호 K
	 */
	//K번째 사람이 제거되고 그 배열에서 다시 K번째 사람 제거
	//배열이 빌때까지
	//이거 배열 문제인가?
	static int[] input;
	static int N, K;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		input = new int[N+1];
		for(int i = 0; i<N+1; i++) {
			input[i] = i;
		}
		
		//죽으면 0으로
		int deathCnt = 0;//죽은 사람이 생기면 하나씩 증가 N이 나오면 종료
		
		int idx = 1;//배열을 반복적으로 원을 그리면서 계속 탐색
		int aliveCnt = 1;
		sb.append("<");
		while(true) {
			if(deathCnt==N)break;
			
			if(input[idx]!=0) {
				if((aliveCnt%K)==0) {
					sb.append(input[idx]).append(", ");
					input[idx] = 0;
					deathCnt++;
				}
				aliveCnt++;
			}
			
			idx++;
			if(idx>N)idx = 1;
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb);
	}
}

