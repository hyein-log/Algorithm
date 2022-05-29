package week0;

import java.util.Scanner;

public class º°Âï±â2442 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int max = 2*n-1;
		for(int i = 0; i<n; i++) {
			int num = ((i+1)*2)-1;
			int bound1 = (max-num)/2;
			int bound2 = bound1+num;
			for(int j = 0; j<max; j++) {
				if(j>=bound1&&j<bound2) {
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
