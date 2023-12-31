package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12891_DNAPW2 {
	static int S, P, ans;
	static char[] dna;// string 대신 char
	static int minA, minG, minC, minT, cntA, cntG, cntC, cntT;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		S = Integer.parseInt(st.nextToken());// 배열 길이
		P = Integer.parseInt(st.nextToken());// 배열 길이
		dna = bf.readLine().toCharArray();

		st = new StringTokenizer(bf.readLine());
		minA = Integer.parseInt(st.nextToken());
		minG = Integer.parseInt(st.nextToken());
		minC = Integer.parseInt(st.nextToken());
		minT = Integer.parseInt(st.nextToken());

		solve();
		System.out.println(ans);
	}

	static void solve() {
		// 전체 문자열 S의 맨 앞 P(부분 문자열의 길이)개의 문자를 우선 계산
		for (int i = 0; i < P; i++) {
			switch (dna[i]) {
			case 'A':
				cntA++;
				break;
			case 'C':
				cntC++;
				break;
			case 'G':
				cntG++;
				break;
			case 'T':
				cntT++;
				break;
			}
		}

		check();
		// 이후에는 P 문자열 맨 앞을 버리고 P 문자열 맨 뒤에 이어지는 문자를 얻는 과정 반복(끝에 도달할 때 까지)
		// 함께 유효성 검증 => 통과하면 ans 추가 check() 별도로 구현

		for (int i = P; i < S; i++) {
			switch (dna[i - P]) {
			// 이전 부분 문자열보다 새로운 부분 문자열을 완성
			// 맨 앞 버린다
			case 'A':
				cntA--;
				break;
			case 'C':
				cntC--;
				break;
			case 'G':
				cntG--;
				break;
			case 'T':
				cntT--;
				break;
			}
			// 맨 뒤 다음거 하나 겟
			switch (dna[i]) {
			case 'A':
				cntA++;
				break;
			case 'C':
				cntC++;
				break;
			case 'G':
				cntG++;
				break;
			case 'T':
				cntT++;
				break;
			}
			check();
		}
	}

	// check가 호출 될 떄는 부분 문자열 경우가 하나 완성된 상태
	static void check() {
		if (cntA >= minA && cntC >= minC && cntG >= minG && cntT >= minT)
			ans++;
	}
}
