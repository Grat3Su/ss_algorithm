package basic.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class StackQueueTest {

	public static void main(String[] args) {
		//stack
		//push-pop
		Stack<Integer> stack = new Stack<>();
		stack.push(3);
		stack.push(5);
		stack.push(2);
		stack.push(7);

		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}System.out.println();
		
		Deque<Integer> stackAd =  new ArrayDeque<>(); 
		
		stackAd.push(3);
		stackAd.push(5);
		stackAd.push(2);
		stackAd.push(7);
		stackAd.peek();
		while(!stackAd.isEmpty()) {
			System.out.print(stackAd.pop()+" ");
		}System.out.println();
		
		//Queue - Interface
		//offer()-pool()
		
		Queue<Integer> queueAd =  new ArrayDeque<>(); 
		
		queueAd.offer(3);
		queueAd.offer(5);
		queueAd.offer(2);
		queueAd.offer(7);
		while(!queueAd.isEmpty()) {
			System.out.print(queueAd.poll()+" ");
		}
		System.out.println();
	}

}
