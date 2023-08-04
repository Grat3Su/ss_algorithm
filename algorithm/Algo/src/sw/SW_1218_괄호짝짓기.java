package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import com.sun.xml.internal.ws.addressing.ProblemAction;

public class SW_1218_괄호짝짓기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		char[][] bracket = { { '(', ')' }, { '{', '}' }, { '[', ']' }, { '<', '>' } };
		Stack<Character> stack = new Stack<Character>();

		String s = br.readLine();
		char[] problem = s.toCharArray();
		int result = 0;

		for (int i = 0; i < T; i++) {
			
			if(stack.isEmpty())
				break;
			
			for (int j = 0; j < 4; j++) {
				if (problem[i] == bracket[j][0]) {
					stack.add(problem[i]);
				} else if (problem[i] == bracket[j][1]) {
					if (stack.peek() == bracket[i][0]) {
						stack.pop();
					}
				}

			}
		}
		if(stack.isEmpty())
			result = 1;
		System.out.println(result);
	}
}
