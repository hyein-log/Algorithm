package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 스택수열1872 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		while(n-->0) {
			int num = Integer.parseInt(br.readLine());
			if(arr[num-1]==0) {
				for(int i = 0; i<num; i++) {
					if(arr[i]==0) {
						arr[i]= i+1;
						sb.append("+\n");
					}
					if(i==num-1) {
						sb.append("-\n");
					}
				}
			}else {
				sb.append("-\n");
			}
			
		}
		System.out.println(sb);
	}

}
