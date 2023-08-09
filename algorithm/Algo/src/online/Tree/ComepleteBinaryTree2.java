package online.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class ComepleteBinaryTree2 {
	private Object[] nodes;
	private int lastIdx;//.
	private final int SIZE;
	public ComepleteBinaryTree2(int size) {
		SIZE = size;
	}
	public void bfs2() {
		
	}
	
	int lastidx;
	private void dfsByPreOrder(int current) {//현재 노드를 전위 순회로 탐색
		Queue<Integer> queue = new ArrayDeque<Integer>();
System.out.println();
		//현재 탐색대상을 통해 탐색해야할 새로운 대상을 재ㅟ 호출로 탐색시키기
		if(current*2<=lastIdx) dfsByPreOrder(current*2);
		if(current*2+1<=lastIdx) dfsByPreOrder(current*2+1);
	}
}
