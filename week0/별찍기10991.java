package week0;

import java.util.Scanner;

public class º°Âï±â10991 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int max = n + (n - 1);
		for (int i = 0; i < n; i++) {
			int bound1 = (max - 1) / 2 - i;
			int bound2 = (max - 1) / 2 + i;
			if (i % 2 == 0&&n%2==1) {
				for (int j = 0; j < max; j++) {
					if (j % 2 == 0 && j <= bound2 && j >= bound1) {
						System.out.print("*");
						if(j==bound2) break;
					} else {
						System.out.print(" ");
					}
				}
				System.out.println();
			} else if(i%2==1&&n%2==1){
				for (int j = 0; j < max; j++) {
					if (j % 2 == 1 && j <= bound2 && j >= bound1) {
						System.out.print("*");
						if(j==bound2) break;
					} else {
						System.out.print(" ");
					}
				}
				System.out.println();
			} else if(i%2==0&&n%2==0) {
				for(int j = 0; j<max ; j++) {
					if(j%2==1&&j<=bound2&&j>=bound1) {
						System.out.print("*");
						if(j==bound2) break;
					}
					else {
						System.out.print(" ");
					}
					
				}
				System.out.println();
			} else if(i%2==1&&n%2==0) {
				for(int j = 0; j<max; j++) {
					if(j%2==0&&j<=bound2&&j>=bound1) {
						System.out.print("*");
						if(j==bound2)break;
					}
					else {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}

	}

}
