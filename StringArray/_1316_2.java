package StringArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1316_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k=0, i =0;
		while(n-->0) {
			String str = br.readLine();
			char arr[] = str.toCharArray();
			loop:for(i=1; i<arr.length; i++) {
				if(arr[i] != arr[i-1]) {
					for(int j=0; j<i; j++) {
						if(arr[j]==arr[i]) {
							break loop;	
						}
					}
				}
			}
			if(i==arr.length || str.length()==1) {
				k++;
			}
		}
		System.out.println(k);
		br.close();
	}
}
