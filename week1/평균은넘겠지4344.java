package week1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class 평균은넘겠지4344 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int tc = scanner.nextInt();
		while(tc-->0) {
			int[] arr = new int[scanner.nextInt()];
			double sum = 0;
			for(int i = 0; i<arr.length; i++) {
				arr[i] = scanner.nextInt();
				sum+= arr[i];
			}
			double avg = sum/arr.length;
			int count = 0;
			for(int i = 0; i<arr.length; i++) {
				if(arr[i]>avg) {
					count ++;
				}
			}
			double ratio = ((double)count/arr.length)*100;
			DecimalFormat df = new DecimalFormat("0.000");
			System.out.println(df.format(ratio)+"%");
		}
	}

}
