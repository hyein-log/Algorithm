package week1;

import java.util.Arrays;
import java.util.Scanner;

public class ЦђБе1546 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i]=scanner.nextInt();
		}
		Arrays.sort(arr);
		int max = arr[arr.length-1];
		double sum = 0;
		for(int i = 0; i<arr.length; i++) {
			sum +=((double)arr[i]/max)*100;
			
		}
		System.out.println(sum/n);
	}

}
