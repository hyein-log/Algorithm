package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//한 쌍의 괄호 기호로 된 “( )” 문자열은 기본 VPS 이라고 부른다.
//예를 들어 “(())()”와 “((()))” 는 VPS 이지만 “(()(”, “(()” 는 모두 VPS 가 아닌 문자열이다. 
//여러분은 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내어야 한다. 
public class _9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Stack<String> stack = new Stack<>();
		while (tc-- > 0) {
			String str = br.readLine();
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(') {
					stack.push(String.valueOf(str.charAt(i)));
				} else {
					if (stack.size() > 0) {
						stack.pop();
					} else {
						stack.push(String.valueOf(str.charAt(i)));
						break;
					}
				}
			}
			if (stack.isEmpty()) {
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
			}
			stack.clear();
		}
		System.out.println(sb);
	}
}
