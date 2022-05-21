package _arrays;

import java.util.Scanner;

public class _1546 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		double[] arr = new double[n];
		for(int i=0; i<n; i++) {
			arr[i] = scan.nextInt();
		}
		double max = arr[0];
		for(int i=0; i<n; i++) {
			if(arr[i]>max)
				max = arr[i];
		}
		double sum=0;
		for(int i=0; i<n; i++) {
			sum +=arr[i]/max*100;
		}
		
		System.out.println(sum/n);
	}

}
