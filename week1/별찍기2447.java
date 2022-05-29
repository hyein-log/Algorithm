package week1;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

public class º°Âï±â2447 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nString = br.readLine();
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(nString);
		String[][] arr = new String[n][n];
		
		arr = makeArr(arr, n);
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr.length; j++) {
				if(arr[i][j]==null) {
					sb.append("*");
				}
				else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}

	private static String[][] makeArr(String[][] arr, int n) {
		if(n==1) {
			return arr;
		}else {
			int row = n/3;
			int col = n/3;
			for(int i = 0; i<arr.length; i++) {
				col = n/3;
				if(i == row+(n/3)) {
					row = row+n;
					if(row>arr.length)break;
				}
				else if(i>=row&&i<row+(n/3)) {
					for(int j = 0; j<arr.length; j++) {
						if(j==col+(n/3)) {
							col = col+n;
							if(col>arr.length)break;
						}
						else if(j>=col&&j<col+(n/3)) {
							arr[i][j]=" ";
						}
						
					}
				}
			}
			n = n/3;
			return makeArr(arr, n);
		}
	}

	
}
