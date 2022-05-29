package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 단어정렬1181 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		for(int i = 0;i<arr.length; i++) {
			arr[i] = br.readLine();
		}
		Arrays.sort(arr, (a,b)->{
			if(a.length()!=b.length()) return a.length()-b.length();
			else {
				for(int i = 0; i<a.length(); i++) {
					if(a.charAt(i)!=b.charAt(i)) {
						return a.charAt(i)-b.charAt(i);
					}
				}
				return 0;
			}
		});
		for(int i = 0; i<arr.length; i++) {
			if(i!=0&&arr[i].equals(arr[i-1])) {
				continue;
			}else {
				System.out.println(arr[i]);
			}
		}
	}

}
