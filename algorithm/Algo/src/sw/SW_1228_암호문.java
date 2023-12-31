package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SW_1228_암호문 {
	static int N, M;
	static LinkedList<String> list = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t<=10; t++) {
			list.clear();
			
			N = Integer.parseInt(br.readLine());//첫째줄
			StringTokenizer st = new StringTokenizer(br.readLine());//둘째줄
			for(int i = 0; i<N; i++) {
				list.add(st.nextToken());
			}
			
			M = Integer.parseInt(br.readLine());//셋째줄
			st = new StringTokenizer(br.readLine());//넷째줄
			
			//M개의 명령어 순차처리
			for(int i = 0; i<M; i++) {
				st.nextToken();//I 버려
				int x = Integer.parseInt(st.nextToken());//index
				int y = Integer.parseInt(st.nextToken());//들어갈 문자열 수
				int count = x+y;//x 위치에 y개 만큼 문자열 추가
				for(int j = x; j<count; j++) {
					list.add(j, st.nextToken());
				}
			}
			
			sb.append("#").append(t).append(" ");
			for(int i = 0; i<10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");			
		}
		System.out.println(sb);
	}

}
