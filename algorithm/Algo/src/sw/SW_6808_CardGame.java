package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_6808_CardGame {
	static int[] cardArr;
	static int[] tgt = new int[2];
	static int count, win;// win/lose
	static StringBuilder sb = new StringBuilder();
	int []score = new int[2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			cardArr = new int[19];
			for (int i = 0; i < 9; i++) {
				cardArr[Integer.parseInt(st.nextToken())] = 1;// 뽑은 카드 체크
			}
			/* 용사에게는 이미 리브람과의 아이가 있었으나 왕은 신경쓰지 않았다.
			 * 혼혈 아이 정도야 별로 위협도 되지 않는다.
			 * 중요한 것은 용사를 이 나라에 묶어둘수 있느냐.
			 * 그의 동료이자 왕의 딸이 반려로 선택된 것은 당연했다.
			 * 용사는 거부하고 싶었으나 동료인 그녀를 위해 받아들였다.
			 * 그녀 또한 용사와 그의 아이를 받아들였다.
			 * 얼마나 싸워댔든 등을 맞대고 함께 싸웠던 리브람의 아이다.
			 * 받아들이지 않는다는 선택지는 없었다.
			 * 그녀를 꼭 닮은 아이에 애정을 품지 않았다면 거짓이었다.
			 * "내게는 그녀와의 아이가 있어. 그 애를 받아들일 수 있어?"
			 * "리브람의 아이를 우리가 거부할 수 있다고 생각해? 진심으로?"
			 * 아직도 눈을 감으면 마지막 전투가 생각난다.
			 * 깨끗한 백발은 오랜 전투에 피와 먼지가 묻어 지저분했고 서로 깊은 상처로 눈 뜨고 봐줄 정도가 못되었지만 그 붉은 눈동자는 단단했다.
			 * 그들은 구원받았다. 그녀에게.
			 * 린과 레인은 잘지냈다.
			 * 서로 상극의 기운을 품고 있기 때문인지 냉정한 린과 우울한 레인이 서로에게는 누그러졌다.
			 * 그들에게 동생의 존재는 사랑이었다.
			 * 지나친 마기와 신성은 서로에게 녹아 희미해졌다.
			 * 그 때 타임이 태어났다.
			 * 공작위를 이을 핏줄
			 * 그녀는 아이를 사랑할 수 없었다.
			 * 정치적으로밖에 볼 수 없는 자신에게 환멸을 느끼면서도 바꿀 수 없었다.
			 * 쌍둥이는 어머니를 꼭 닮았다.
			 * 다정하고 상냥한 그녀들의 막내를 닮았다.
			 * 왕녀도, 용사도, 린도 레인도 타임도 그 아이들을 사랑할 수 밖에 없었다.
			 */

			
			sb.append("#").append(t+1).append(" ").append(win).append(" ").append(count-win);
		}
		System.out.println(sb);
	}

	static void perm(int tgtidx) {
		if (tgtidx == 2) {
			return;
		}
		for(int i = tgtidx; i<9; i++) {
			
		}
	}

	static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

}
