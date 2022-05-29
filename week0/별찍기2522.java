package week0;

import java.util.Scanner;

public class º°Âï±â2522 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();
		for(int i = 0; i<n; i++) {
			int bound = n-i-1;
			for(int j = 0; j<n; j++) {
				if(j<bound) {
					System.out.print(" ");
				}
				else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		for(int i = n-1; i>0;i--) {
			int bound = n-i;
			for(int j = 0; j<n; j++) {
				if(j<bound) {
					System.out.print(" ");
				}
				else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

}
