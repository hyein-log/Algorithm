package week0;

import java.util.Scanner;

public class 숫자의합11720 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int length = input.nextInt();
		int result = 0;
		input.nextLine();
		String[] arr = input.nextLine().split("");
		
		for(int i = 0; i<length; i++) {
			result+= Integer.parseInt(arr[i]);
		}
		System.out.println(result);
	}

}
