package algo_A;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/*N
 * 인구수
 * 인접 간선
 * 6
5 2 3 4 1 2
2 2 4
4 1 3 6 5
2 4 2
2 1 3
1 2
1 2
 */
public class Gerrymendaring {
	static int N;
	static int[] citizen;
	static List<List<Integer>> adjlist;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		citizen = new int[N+1];
		adjlist = new ArrayList<>();
		
		for(int i = 1; i<=N; i++) {
			adjlist.add(new ArrayList<>());
		}
		
		for(int i = 1; i<=N; i++) {
			citizen[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for(int j = 0; j<n; j++)
				adjlist.get(i).add(Integer.parseInt(st.nextToken()));
		}

	}

}
