package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

import com.sun.xml.internal.fastinfoset.util.CharArrayArray;
import com.sun.xml.internal.ws.addressing.ProblemAction;

public class SW_1218_괄호짝짓기2 {
	static int N, ans;
	static StringBuilder sb= new StringBuilder();
	static char[] charArr;
	static Deque<Character> stack = new ArrayDeque<Character>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 0; t < 10; t++) {
			N = Integer.parseInt(br.readLine());
			charArr = br.readLine().toCharArray();
			stack.clear();
			ans = 0;
			for (int i = 0; i < N; i++) {
				char token = charArr[i];
				if (token == '<' || token == '(' || token == '{' || token == '[') {
					stack.push(token);
				} else {// 닫는 문자
					if (stack.isEmpty()) {//시작부터 닫는 tag
						stack.push(token);
					}
					// 매칭이 안되면 안꺼내고 break
					char prev = stack.peek();
					if (prev != '<' && token == '>')
						break;
					else if (prev != '(' && token == ')')
						break;
					else if (prev != '{' && token == '}')
						break;
					else if (prev != '[' && token == ']')
						break;
					else
						stack.pop();
				}
			}			
			if(stack.isEmpty()) ans =1;
			sb.append("#").append((t+1)).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
