package week0;

import java.util.Scanner;

public class º°Âï±â2441 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for(int i = n; i>0; i--) {
			int bound = n-i;
			for(int j = 0; j<n; j++) {
				if(j>=bound) {
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
