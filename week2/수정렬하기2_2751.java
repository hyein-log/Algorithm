package week2;

import java.util.Scanner;


public class 수정렬하기2_2751 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for(int i =0; i<arr.length; i++) {
			arr[i] = scanner.nextInt();
		}
		scanner.close();
		for(int i = 0; i<arr.length-1; i++) {
			for(int j =i+1;j<arr.length; j++) {
				if(arr[i]>arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j]= tmp;
				}
			}
		}
		for(int i = 0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
