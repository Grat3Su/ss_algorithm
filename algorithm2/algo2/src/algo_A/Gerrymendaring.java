package algo_A;
import java.io.*;
import java.util.*;
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
	static int N, ans;
	static int[] citizen;
	static boolean[] visit;
	static boolean[] select;
	static List<List<Integer>> adjlist;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()); 

		//초기화
		ans = Integer.MAX_VALUE;
		citizen = new int[N];
		select = new boolean[N];
		visit = new boolean[N];
		
		adjlist = new ArrayList<>();
		for(int i = 0; i<N; i++) {
			adjlist.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i<N; i++) {
			citizen[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for(int j = 0; j<n; j++)
				adjlist.get(i).add(Integer.parseInt(st.nextToken())-1);
		}

		Divide(0);
		System.out.println(ans == Integer.MAX_VALUE? -1:ans);

	}

	static void Divide(int idx){
		if(N == idx){
			List<Integer> alist = new ArrayList<>();
			List<Integer> blist = new ArrayList<>();

			for(int i = 0; i<N; i++){
				if(select[i]) alist.add(i);
				else if(!select[i]) blist.add(i);				
			}
			if(alist.size() == 0|| blist.size() == 0) return;//한 지역에 모두 있으면 안됨
			if(Check(alist)&&Check(blist)){
				int asum = 0;
				int bsum = 0;

				for(int i = 0; i<N; i++){
					if(select[i])//A구역
					asum+=citizen[i];
					else
					bsum += citizen[i];
				}

				ans = Math.min(ans, Math.abs(asum-bsum));
			}			
			return;
		}

		select[idx] = true;
		Divide(idx+1);
		select[idx] = false;
		Divide(idx+1);
	}

	static boolean Check(List<Integer> list){//구역 확인
	Queue<Integer>q = new ArrayDeque<>();
		visit = new boolean[N];
		visit[list.get(0)] = true;
		q.offer(list.get(0));
		int cnt = 1;//방문한 지역 수
		while(!q.isEmpty()){
			int cur = q.poll();
			for(int i = 0; i<adjlist.get(cur).size(); i++){
				int n = adjlist.get(cur).get(i);
				if(list.contains(n)&& !visit[n]){
					q.offer(n);
					visit[n] = true;
					cnt++;
				}
			}
		}		
		
		if(cnt == list.size()) return true;//선거구 수 = 방문한 지역 수
		else return false;
	}

}
