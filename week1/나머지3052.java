package week1;

import java.util.Arrays;
import java.util.Scanner;

public class ³ª¸ÓÁö3052 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int arr[] = new int[10];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = scanner.nextInt()%42;
		}
		Arrays.sort(arr);
		int count = 1;
		for(int i = 0; i<arr.length-1; i++) {
			if(arr[i]!=arr[i+1]) {
				count++;
			}
		}
		System.out.println(count);
	}

}
