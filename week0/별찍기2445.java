
package week0;

import java.util.Scanner;

public class º°Âï±â2445 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();
		int max = 2*n;
		for(int i = 0; i<n; i++) {
			int bound1 = i;
			int bound2 = (max-1)-bound1;
			for(int j = 0; j<max; j++) {
				if(j<=bound1||j>=bound2) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		for(int i= n-1; i>0; i--) {
			int bound1 = i-1;
			int bound2 = (max-1)-bound1;
			for(int j  = 0; j<max; j++) {
				if(j<=bound1||j>=bound2) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
