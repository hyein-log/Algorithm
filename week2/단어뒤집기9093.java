package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단어뒤집기9093 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		String[][] arr = new String[n][];
		for(int i = 0; i<n; i++) {
			arr[i]= br.readLine().split(" ");
		}
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr[i].length; j++) {
				if(arr[i][j].length()==1) {
					sb.append(arr[i][j]);
					sb.append(" ");
				}else {
					for(int k = arr[i][j].length()-1;k>=0;k--) {
						sb.append(arr[i][j].charAt(k));
					}
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
