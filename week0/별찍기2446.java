package week0;

import java.util.Scanner;

public class º°Âï±â2446 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int max = 2*n-1;
		for(int i =n; i>0; i--) {
			int bound1 = n-1-i;
			int bound2 = n-1+i;
			
			for(int j = 0; j<max; j++) {
				if(j<bound2&&j>bound1) {
					System.out.print("*");
					if(j==bound2-1)break;
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		for(int i = 2; i<n+1;i++) {
			int bound1 = n-1-i;
			int bound2 = n-1+i;
			for(int j = 0; j<max; j++) {
				if(j<bound2&&j>bound1) {
					System.out.print("*");
					if(j==bound2-1) break;
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}
