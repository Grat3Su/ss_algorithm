package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_1158_요세푸스 {
	/*	데이터셋
	 * 	7 3
	 * 	사람 수 N과 제거할 번호 K
	 */
	//K번째 사람이 제거되고 그 배열에서 다시 K번째 사람 제거
	//배열이 빌때까지
	//이거 배열 문제인가?
	static int[] removePeople;
	static int N, K;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		removePeople = new int[N];
		peopleNode<Integer> head = new peopleNode<Integer>(0, null);
		for(int i = 0; i<N; i++) {//people 배열 생성			
			head.setLink(new peopleNode<Integer>(i+1, head.getLink()));
		}
		int idx = 0;

		
	}
}
class peopleNode<T>{
	private T value;
	private peopleNode<T> link;
	
	public peopleNode(T value, peopleNode<T> link) {
		this.value = value;
		this.link = link;
	}
	
	public T getVale() { return value; }
	public peopleNode<T> getLink() { return link; }
	public void setVale(T value) { this.value = value; }
	public void setLink(peopleNode<T> link) { this.link = link; }
}
