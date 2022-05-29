package week0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class º°Âï±â10991_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i<n; i++) {
			int max = n-1-i;
			for(int j = max; j>0; j--) {
				System.out.print(" ");
			}
			System.out.print("*");
			for(int j=0;j<i;j++) {
				
				System.out.print(" ");
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
