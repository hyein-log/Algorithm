package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * ������ �����ϴ� ť�� ������ ����, �Է����� �־����� ����� ó���ϴ� ���α׷��� �ۼ��Ͻÿ�.
����� �� ���� �����̴�.
push X: ���� X�� ť�� �ִ� �����̴�.
pop: ť���� ���� �տ� �ִ� ������ ����, �� ���� ����Ѵ�. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
size: ť�� ����ִ� ������ ������ ����Ѵ�.
empty: ť�� ��������� 1, �ƴϸ� 0�� ����Ѵ�.
front: ť�� ���� �տ� �ִ� ������ ����Ѵ�. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
back: ť�� ���� �ڿ� �ִ� ������ ����Ѵ�. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
 */
public class _10845 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<Integer>();
		int X =0;
		while(tc-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();
			switch (str) {
			case "push":
				int n = Integer.parseInt(st.nextToken());
				queue.add(n);
				X = n;
				break;
			case "pop":
				String x = String.valueOf(queue.poll());
				if(x != "null") {
					sb.append(x).append("\n");
				}else {
					sb.append("-1").append("\n");
				}
				break;
			case "size":
				sb.append(queue.size()).append("\n");
				break;
			case "empty":
				if(queue.isEmpty()) {
					sb.append("1").append("\n");
				}else {
					sb.append("0").append("\n");
				}
				break;
			case "front":
				x = String.valueOf(queue.peek());
				if(x!="null") {
					sb.append(queue.peek()).append("\n");
				}else {
					sb.append("-1").append("\n");
				}
				break;
			default://back
				if(queue.size()!=0) {
					sb.append(X).append("\n");
				}else {
					sb.append("-1").append("\n");
				}
				break;
			}
		}
		System.out.println(sb);
	}

}
