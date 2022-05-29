package week0;

import java.util.Scanner;

public class AplusB5 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			int a = input.nextInt();
			int b = input.nextInt();
			int result = a+b;
			if(result ==0) break;
			else System.out.println(result);
		}
		
	}

}
