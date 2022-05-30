package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//단어 뒤집기
//문장이 주어졌을 때, 단어를 모두 뒤집어서 출력하는 프로그램을 작성하시오. 
//단, 단어의 순서는 바꿀 수 없다. 단어는 영어 알파벳으로만 이루어져 있다.
public class _9093 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(tc-->0) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			while(st.hasMoreTokens()) {
				String word = st.nextToken();
				char[] arr = word.toCharArray();
				for(int i=arr.length-1; i>=0; i--) {
					sb.append(arr[i]);
				}
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
