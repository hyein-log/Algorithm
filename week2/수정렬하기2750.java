package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수정렬하기2750 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nString = br.readLine();
		int n = Integer.parseInt(nString);
		int[] arr = new int[n];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		Arrays.sort(arr);
		for(int i = 0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
