package basic.DFSBFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


//정점 1 2 3 4
// 1-> 2 4 	: 1번 리스트에  4 담고
// 2-> 3 4 	: 2번 리스트에 3 4
// 3-> 2	: 3번 리스트에 2
// 4-> 3	: 4번 리스트에 3
//->전체 리스트 생성
//위 정점과 간선 정보를 어떻게 표현할 것인가?
// 각 정점에서 다른 정점으로 가는 정보를 정점별 리스트를 구성(1->list, 2->list...)
//그래프에서는 중복 방문을 피하기 위해 별도의 자료구조 visit 필요

public class GraphList2 {
	static List<List<Integer>> adjList = new ArrayList<>(); 
	static boolean[] visit;//정점의 수만큼(해당 정점을 이미 방문했는지 여부)
	public static void main(String[] args) {
		//adjlist 초기화
		for(int i = 0; i<5; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		
		adjList.get(1).add(2);
		adjList.get(1).add(4);
		adjList.get(2).add(3);
		adjList.get(2).add(4);
		adjList.get(3).add(2);
		adjList.get(4).add(3);
		visit = new boolean[5];//0 : dummy
		bfs(1);
		
		System.out.println();
		visit = new boolean[5];//0 : dummy
		visit[1] = true;
		
		dfs(1);
	}
	
	static void bfs(int n) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(n);
		visit[n] = true;
		
		while(!queue.isEmpty()) {
			int v = queue.poll();//얘로부터 갈 수 ㅇㅆ는 루트들은 큐에 저장해야함
			System.out.print(v+"->");
			List<Integer>list = adjList.get(v);
			for(Integer i:list) {
				if(visit[i]) continue;
				queue.offer(i);
				visit[i] = true;
			}
		}
	}
	static void dfs(int n) {
		//배열을 이용하는 dfs(idx)처럼 index가 증가하는 문제로 인한 ㄱ저조건 필요없음
		//visit + foreach(갈 수 있는 곳만 가는 반복문)로 해결
		System.out.print(n+"->");
		List<Integer>list = adjList.get(n);
		for(Integer i:list) {
			//visit
			if(visit[i])continue;
			visit[i] = true;
			dfs(i);
		}
	}
	
}
