package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _9093_1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		Stack<String> stack = new Stack<String>();
		StringBuilder sb = new StringBuilder();
		while (tc-- > 0) {
			String str = br.readLine()+" ";
			for (int i = 0; i <str.length(); i++) {
				if (str.charAt(i) != ' ') {
					stack.push(String.valueOf(str.charAt(i)));
				} else {
					while (!stack.empty()) {
						sb.append(stack.pop());
					}
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
