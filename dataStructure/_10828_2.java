package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _10828_2 {
	static Stack<Integer> stack = new Stack<Integer>();
	static int size = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		while (tc-- > 0) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			String order = st.nextToken();
			switch (order) {
			case "push":
				stack.push(Integer.parseInt(st.nextToken()));
				size++;
				break;
			case "pop":
				if (size == 0) {
					sb.append(-1).append("\n");
					break;
				}
				sb.append(stack.pop()).append("\n");
				size--;
				break;
			case "size":
				sb.append(stack.size()).append("\n");
				break;
			case "empty":
				if (size == 0) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
				break;

			default:
				if (size == 0) {
					sb.append(-1).append("\n");
					break;
				}
				sb.append(stack.peek()).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}
}
