package basic.DFSBFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTree {
	static int[] tree= {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		bfs(1);
		System.out.println(sb);

		sb.setLength(0);
		
		dfs(1);
		 sb.setLength(sb.length()-2);
		System.out.println(sb);
	}
	static void bfs(int idx) {
		//최초 시작 노드를 큐에 넣고 시작
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(idx);
		
		while(!queue.isEmpty()) {
			//노드를 꺼내고 그 노드로부터 갈수 있는 다른 노드를 큐에 담는다
			int curIdx= queue.poll();
			//방문기록
			sb.append(tree[curIdx]).append("->");
			
			//갈 수 있는 다른 노드<=완전 이진트리(top->bottom)
			//갈 수 있는의 의미는 왼쪽 자식, 오른쪽 자식 노드가 있으면이라는 의미
			int lcIdx = curIdx*2;
			int rcIdx = curIdx*2+1;
			
			//길이를 가진 유한한 트리라서 범주 안에 들어있는지 확인 작업 필요
			if(lcIdx<tree.length)queue.offer(lcIdx);
			if(rcIdx<tree.length)queue.offer(rcIdx);
			
		}
		 sb.setLength(sb.length()-2);
	}
	static void dfs(int idx) {
		//기저조건
		if(idx >= tree.length) return;
				
		//방문기록
		sb.append(tree[idx]).append("->");
		//자식이 있으면 자식 방문
		dfs(idx*2);//왼쪽으로 방문할 수 있는 자식 노드를 모두 방문하고 오른쪽 자식 노드를 방문
		dfs(idx*2+1);
	}
}