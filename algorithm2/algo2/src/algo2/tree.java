package algo2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class tree {
	static int N;
	static List<List<Node>>adjList;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		adjList = new ArrayList<>();
		for(int i = 0; i<=N; i++) {
			adjList.add(new ArrayList<Node>());
		}
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			for(;;) {
				int v2 = Integer.parseInt(st.nextToken());
				if(v2 == -1)break;
				int c = Integer.parseInt(st.nextToken());
				
				adjList.get(v).add(new Node(v2,c));
			}
		}
		
		for(int i = 1; i<=N; i++) {
			System.out.println(adjList.get(i));
		}

	}

	public static class Node{
		int v, c;

		@Override
		public String toString() {
			return "Node [v=" + v + ", c=" + c + "]";
		}

		public Node(int v, int c) {
			super();
			this.v = v;
			this.c = c;
		}
	}
}
