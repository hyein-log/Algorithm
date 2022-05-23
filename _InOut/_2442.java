package _InOut;

import java.util.Scanner;

public class _2442 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i=n; i>0; i--) {
			for(int j=0; j<n-i; j++ ) {
				System.out.print(" ");
			}
			for(int a =0; a<2*i-1; a++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
