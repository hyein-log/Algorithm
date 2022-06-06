package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10799 {

	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int n=0;
		int sum=0;
		char[] arr = str.toCharArray();
		for(int i=0; i<str.length(); i++) {
			switch (arr[i]) {
			case '(':
				n++;
				break;
			case ')':
				if(arr[i-1]=='(') {
					n--;
					sum +=n;
				}else {
					n--;
					sum+=1;
				}
				break;
			}
		}
		System.out.println(sum);
	}

}
