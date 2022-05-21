package _arrays;

import java.util.Arrays;
import java.util.Scanner;

public class _2577 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		int d = a * b * c;
		String str = String.valueOf(d);
		int arr[] = new int [10];
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			switch (ch) {
			case '0':
				arr[0]++;
				break;
			case '1':
				arr[1]++;
				break;
			case '2':
				arr[2]++;
				break;
			case '3':
				arr[3]++;
				break;
			case '4':
				arr[4]++;
				break;
			case '5':
				arr[5]++;
				break;
			case '6':
				arr[6]++;
				break;
			case '7':
				arr[7]++;
				break;
			case '8':
				arr[8]++;
				break;

			default:
				arr[9]++;
				break;
			}
		}
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
