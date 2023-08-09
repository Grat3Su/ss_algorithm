package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hwalgo07_부울경_3반_장수영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;  //넓이
        int N = Integer.parseInt(br.readLine());  //색종이 개수
        boolean[][] arr = new boolean[100][100];  //도화지
        for (int t = 0; t < N; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int i = x; i < x+10; i++) {
                for (int j = y; j < y+10; j++) {
                    if (!arr[i][j]) {
                        arr[i][j] = true;
                        result++;
                    }
                }
            }
        }
        System.out.print(result);
    }

}
