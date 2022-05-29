package week0;

import java.util.Scanner;

public class AplusB4 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNext()) {
			int a = input.nextInt();
			int b = input.nextInt();
			int result = a+b;
			System.out.println(result);
		}

	}

}
