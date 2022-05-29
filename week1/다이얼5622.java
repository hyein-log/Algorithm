package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ´ÙÀÌ¾ó5622 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		br.close();
		int[] arr = {1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,0,1,0,0,1,0,0,0,1};
		int second = 0;;
		for(int i = 0; i<str.length(); i++) {
			int max = str.charAt(i)-65;
			second+=2;
			if(max>=0&&max<=26) {
				for(int j = 0;j<=max; j++) {
					second+=arr[j];
				}
			}else {
				second+=11;
			}
		}
		System.out.println(second);
	}

}
