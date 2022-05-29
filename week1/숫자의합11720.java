package week1;

import java.util.Scanner;

public class 숫자의합11720 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		String[] arr = scanner.nextLine().split("");
		int sum = 0;
		for(String s: arr) {
			sum+=Integer.parseInt(s);
		}
		System.out.println(sum);
	}

}
