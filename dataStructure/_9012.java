package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//�� ���� ��ȣ ��ȣ�� �� ��( )�� ���ڿ��� �⺻ VPS �̶�� �θ���.
//���� ��� ��(())()���� ��((()))�� �� VPS ������ ��(()(��, ��(()�� �� ��� VPS �� �ƴ� ���ڿ��̴�. 
//�������� �Է����� �־��� ��ȣ ���ڿ��� VPS ���� �ƴ����� �Ǵ��ؼ� �� ����� YES �� NO �� ��Ÿ����� �Ѵ�. 
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
