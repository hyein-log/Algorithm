package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 1���� n������ ���� ���ÿ� �־��ٰ� �̾� �þ�������ν�, �ϳ��� ������ ���� �� �ִ�. 
 * �̶�, ���ÿ� push�ϴ� ������ �ݵ�� ���������� ��Ű���� �Ѵٰ� ����. 
 * ������ ������ �־����� �� ������ �̿��� �� ������ ���� �� �ִ��� ������, 
 * �ִٸ� � ������ push�� pop ������ �����ؾ� �ϴ����� �˾Ƴ� �� �ִ�. 
 * �̸� ����ϴ� ���α׷��� �ۼ��϶�.
 */
public class _1874 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		
		int max = 0;
		boolean flag = true;
		for (int i = 0; i < tc; i++) {
			int n = Integer.parseInt(br.readLine());
			for (int j = max + 1; j <= n; j++) {
				stack.push(j);
				sb.append("+").append("\n");
			}
			if (!stack.isEmpty() && stack.peek() == n) {
				if (n > max) {
					max = n;
				}
				stack.pop();
				sb.append("-").append("\n");
			} else {
				if (!stack.isEmpty() && stack.peek() > n) {
					flag = false;
					break;
				}
			}
		}
		if (flag) {
			System.out.println(sb);
		} else {
			System.out.println("NO");
		}
	}
}
