package week0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class º°Âï±â10992_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i<n; i++) {
			int max = n-1-i;
			if(i == n-1) {
				String str = "*";
				System.out.println(str.repeat(2*n-1));
				break;
			}
			for(int j = max; j>0; j--) {
				System.out.print(" ");
			}
			System.out.print("*");
			for(int j = 0; j<2*i-1;j++) {
				System.out.print(" ");
				if(j==2*i-2)System.out.print("*");
			}
			System.out.println();
			
		}
	}

}
