package week0;

import java.util.Scanner;

public class º°Âï±â10992 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int max = n*2-1;
		for(int i = 0; i<n; i++) {
			int bound1 = (max-1)/2-i;
			int bound2 = (max-1)/2+i;
			if(i==n-1) {
				for(int j = 0; j<max; j++) {
					if(j>=bound1&&j<=bound2) {
						System.out.print("*");
					}
					else {
						System.out.print(" ");
					}
				}
				System.out.println();
				break;
			}
			for(int j = 0; j<max; j++) {
				if(j==bound2) {
					System.out.print("*");
					break;
					
				}
				else if(j==bound1) {
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
