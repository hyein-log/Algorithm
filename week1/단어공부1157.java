package week1;

import java.util.Arrays;
import java.util.Scanner;

public class 단어공부1157 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		char[] arr = scanner.nextLine().toCharArray();
		for(int i = 0; i<arr.length; i++) {
			if(arr[i]<='z'&&arr[i]>='a') {
				arr[i]=(char)(arr[i]-32);
			}
		}
		Arrays.sort(arr);
		
		int num = 0;
		int max = 0;
		int max2 =0;
		int index = 0;
		for(int i = 0; i<arr.length; i++) {
			num ++;
			if(i==arr.length-1||arr[i]!=arr[i+1]) {
				if(num>max) {
					max = num;
					index = i;
					num=0;
				}
				else if(num==max) {
					max2 = num;
					num=0;
				}
				else {
					num=0;
				}
			}
		}
		if(max2==max)System.out.println("?");
		else {
			System.out.println(arr[index]);
		}
		
	}

}
