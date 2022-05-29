package week0;

import java.util.Scanner;

public class AplusB6 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = input.nextInt();
		input.nextLine();
		for(int i = 0; i<tc; i++) {
			String[] arr = input.nextLine().split(",");
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			int result = a+b;
			System.out.println(result);
		}
	}

}
