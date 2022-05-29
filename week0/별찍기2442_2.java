package week0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class º°Âï±â2442_2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nString = br.readLine();
		int n = Integer.parseInt(nString);
		for(int i = 0; i<n ;i++) {
			for(int j = 0;j<n-i;j++) {
				System.out.print(" ");
			}
			for(int j = 0; j<2*i+1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i = n-1;i>=0;i--) {
			for(int j = 0;j<n-i;j++) {
				System.out.print(" ");
			}
			for(int j = 0; j<2*i+1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
