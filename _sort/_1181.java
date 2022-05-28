package _sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1181 {
static int a =0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char [][] arr = new char[n][50];
		for(int i=0; i<n; i++){
			String str = br.readLine();
			for(int j=0; j<str.length(); j++) {
				arr[i][j+1] = str.charAt(j); 
				arr[i][0]++;
			}
		}
		Arrays.sort(arr, (a1, a2)->{
			if(a1[0]==a2[0]){
                 a= (int)sort1(a1,a2,1);
            }else{
                return a1[0]-a2[0];
            }
			return a;
		});
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
			System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	private static int sort1(char[] a1, char[] a2, int i) {
		if((i> a1.length)||(i>a2.length))
			return 0;
			if(a1[i]==a2[i]) {
				i++;
				sort1(a1,a2,i);
			}
				return a1[i] -a2[i];
	}
}
