package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수정렬하기3_10989 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String nString =br.readLine();
		int n = Integer.parseInt(nString);
		int[] arr= new int[n];
		for(int i= 0; i<arr.length; i++) {
			arr[i]= Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		for(int i = 0; i<arr.length; i++) {
			sb.append(arr[i]).append('\n');
		}
		System.out.println(sb);
	}

}
