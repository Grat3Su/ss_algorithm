package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12891_DNAPW3 {
	static int S, P, ans;
	static char[] dna;// string 대신 char
	static int minA, minG, minC, minT, cntA, cntG, cntC, cntT;
	static int[] cnt= new int[20];
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
			cnt[dna[i]-'A']++;
		}
		check();
		// 이후에는 P 문자열 맨 앞을 버리고 P 문자열 맨 뒤에 이어지는 문자를 얻는 과정 반복(끝에 도달할 때 까지)
		// 함께 유효성 검증 => 통과하면 ans 추가 check() 별도로 구현

		for (int i = P; i < S; i++) {
			cnt[dna[i-P]-'A']--;
			cnt[dna[i]-'A']++;
			check();
		}
	}

	// check가 호출 될 떄는 부분 문자열 경우가 하나 완성된 상태
	static void check() {
		if (cnt[0] >= minA && cnt[2] >= minC && cnt[6] >= minG && cnt[19] >= minT)
			ans++;
	}
}
