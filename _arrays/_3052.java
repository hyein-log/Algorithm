package _arrays;

import java.util.Scanner;

public class _3052 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[10];
		int[] arr1 = new int[10];
		for (int i = 0; i < arr.length; i++) {
			int k = scan.nextInt();
			arr[i] = k % 42;
			arr1[i] = arr[i];
		}
		int a = 0;
		for (int i = 0; i < arr.length; i++) {

			for (int j = i - 1; j >= 0; j--) {
				if (arr1[j] == arr[i]) {
					arr1[j] = -1;
				} else
					continue;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr1[i] != -1) {
//				System.out.print(arr1[i]);
				a++;
			}
		}
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(arr1));
		System.out.println(a);
	}
}
