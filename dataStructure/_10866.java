package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _10866 {

	public static void main(String[] args) throws IOException {
		Deque<Integer> dq = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(n-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();
			switch (str) {
			case "push_front":
				dq.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				dq.addLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if(dq.size()==0) {
					sb.append("-1").append("\n");
					break;
				}
				sb.append(dq.pollFirst()).append("\n");
				break;
			case "pop_back":
				if(dq.size()==0) {
					sb.append("-1").append("\n");
					break;
				}
				sb.append(dq.pollLast()).append("\n");
				break;
			case "size":
				sb.append(dq.size()).append("\n");
				break;
			case "empty":
				if(dq.size()==0) {
					sb.append("1").append("\n");
					break;
				}
				sb.append("0").append("\n");
				break;
			case "front":
				if(dq.size()==0) {
					sb.append("-1").append("\n");
					break;
				}
				sb.append(dq.peekFirst()).append("\n");
				break;
			default://back
				if(dq.size()==0) {
					sb.append("-1").append("\n");
					break;
				}
				sb.append(dq.peekLast()).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}

}
