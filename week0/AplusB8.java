package week0;

import java.util.Scanner;

public class AplusB8 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = input.nextInt();
		for(int i = 1; i<=tc;i++) {
			int a = input.nextInt();
			int b = input.nextInt();
			int result = a+b;
			System.out.printf("Case #%d: %d + %d = %d\n",i,a,b,result);
		}
	}

}
