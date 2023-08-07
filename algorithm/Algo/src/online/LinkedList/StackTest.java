package online.LinkedList;

public class StackTest {

	public static void main(String[] args) {
		Istack<String> stack = new LinkedListStack<String>();
		System.out.println(stack.size() + "//"+stack.isEmpty());
		
		stack.push("Helllo");
		stack.push("Worrrld");
		stack.push("Sleeeepy");
		stack.push("OOOhHHoh");
		stack.push("Yeead");
		stack.push("zZzZZzZ");

		System.out.println(stack.peek());
		System.out.println(stack.size() + "//"+stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.size() + "//"+stack.isEmpty());
		System.out.println(stack.pop());
	}

}
