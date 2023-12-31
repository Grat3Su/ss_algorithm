package basic.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueTest2 {

	//stack, queue 구현체 모두 array deque 사용 
	public static void main(String[] args) {
		// stack
		// push-pop

		long start = System.nanoTime();
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < 10000; i++) {
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			stack.pop();
		}
		long end = System.nanoTime();
		System.out.println("stack : "+(end - start));

		start = System.nanoTime();
		Deque<Integer> stackAd = new ArrayDeque<>();
		for (int i = 0; i < 10000; i++) {
			stackAd.push(i);
		}
		while (!stackAd.isEmpty()) {
			stackAd.pop();
		}

		end = System.nanoTime();
		System.out.println("array deque : "+(end - start));

		start = System.nanoTime();

		Queue<Integer> queueLL = new LinkedList<>();
		for (int i = 0; i < 10000; i++) {
			queueLL.offer(i);
		}
		while (!queueLL.isEmpty()) {
			queueLL.poll();
		}

		end = System.nanoTime();
		System.out.println("linked list : "+(end - start));

		start = System.nanoTime();

		Queue<Integer> queueAd = new ArrayDeque<>();
		for (int i = 0; i < 10000; i++) {
			queueAd.offer(i);
		}
		while (!queueAd.isEmpty()) {
			queueAd.poll();
		}

		end = System.nanoTime();
		System.out.println("array deque : "+(end - start));

	}

}
