package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10828_1 {
	static int[] arr;
	static int size = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		arr = new int[tc];
		while (tc-- > 0) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			String order = st.nextToken();
			switch (order) {
			case "push":
				arr[size] = Integer.parseInt(st.nextToken());
				size++;
				break;
			case "pop":
				if (size == 0) {
					sb.append(-1).append("\n");
					break;
				}
				sb.append(arr[size - 1]).append("\n");
				arr[size - 1] = 0;
				size--;
				break;
			case "size":
				sb.append(size).append("\n");
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
				sb.append(arr[size - 1]).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}
}
