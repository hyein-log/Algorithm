package week0;

import java.util.Scanner;

public class гу8393 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int sum = 0;
		for(int i = 1; i<n+1; i++) {
			sum+=i;
		}
		System.out.println(sum);
	}

}
