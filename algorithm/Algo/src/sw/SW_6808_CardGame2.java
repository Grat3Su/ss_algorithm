package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//비트마스크
public class SW_6808_CardGame2 {
	static int[] input = new int[19];
	static int[] guCard = new int[9];
	static int[] inCard = new int[9];
	static int[] tgt = new int[9];
	static int count, win, lose,N,T;// win/lose
	static StringBuilder sb = new StringBuilder();
	int []score = new int[2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		N = 9;
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			win = 0;
			lose = 0;
			Arrays.fill(input, 0);
			//규영이 카드
			int num = 0;			
			for (int i = 0; i < N; i++) {
				num = Integer.parseInt(st.nextToken());// 뽑은 카드 체크
				input[num] =1;
				guCard[i] = num;
			}
			//인영이 카드
			num = 0;
			for(int i = 1; i<=18; i++) {
				//num = Integer.parseInt(st.nextToken());
				if(input[i]==0) {
					inCard[num++] = i;
				}
			}
			perm(0,0);
			
			sb.append("#").append(t+1).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		System.out.println(sb);
	}

	static void perm(int tgtidx, int mask) {
		if (tgtidx == N) {
			check();
			return;
		}
		for(int i = 0; i<N; i++) {
			if((mask&1<<i)!=0)continue;
			tgt[tgtidx] = inCard[i];
			perm(tgtidx+1,mask|1<<i);
		}
	}
	static void check() {
		int guSum = 0;
		int inSum = 0;
		for(int i = 0; i<N; i++) {
			if(guCard[i]>tgt[i]) guSum+=guCard[i]+tgt[i];
			else inSum+=guCard[i]+tgt[i];
		}
		
		if(guSum>inSum)win++;
		else if(guSum<inSum)lose++;
	}

}
