package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 나이순정렬10814 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[][] arr = new String[n][3];
		for(int i = 0; i<arr.length; i++) {
			arr[i][0] = i+"";
			String[] strings = br.readLine().split(" ");
			arr[i][1] = strings[0];
			arr[i][2] = strings[1];
		}
		Arrays.sort(arr,(a,b)->{
			if(a[1].equals(b[1])) {
				return Integer.parseInt(a[0])-Integer.parseInt(b[0]);
			}
			else return Integer.parseInt(a[1])-Integer.parseInt(b[1]);
		});
		for(int i = 0; i<arr.length; i++) {
			System.out.println(arr[i][1]+" "+arr[i][2]);
		}
	}

}
