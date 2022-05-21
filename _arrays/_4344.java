package _arrays;

import java.util.Scanner;

public class _4344 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		while(testcase-- >0) {
			int n = scan.nextInt();
			int[] arr = new int[n];
			int sum = 0;
			for(int i=0; i<n; i++) {
				arr[i] = scan.nextInt();
				sum += arr[i];
			}
			int var = sum/n;
			float count =0;
			for(int i=0; i<n; i++) {
				if(arr[i]>var)
					count++;
			}
			System.out.printf("%.3f%%\n",count/n*100);
		}
	}

}
