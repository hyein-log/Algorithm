package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 좌표정렬하기2_11651 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		for(int i = 0; i<arr.length; i++) {
			String[] strings = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(strings[0]);
			arr[i][1] = Integer.parseInt(strings[1]);
		}
		Arrays.sort(arr, (a,b)->{
			if(a[1]!=b[1]) return a[1]-b[1];
			else return a[0]-b[0];
		});
		for(int i = 0; i<arr.length; i++) {
			for(int j= 0; j<1; j++) {
				System.out.print(arr[i][j]+" "+arr[i][j+1]);
			}
			System.out.println();
		}
	}

}
