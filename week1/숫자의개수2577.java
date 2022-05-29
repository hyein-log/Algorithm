package week1;

import java.util.Arrays;
import java.util.Scanner;

public class 숫자의개수2577{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int value = scanner.nextInt()*scanner.nextInt()*scanner.nextInt();
		String str = value+"";
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		int count = 0;
		int sum = 0;
		for(char i = '0';i<='9';i++) {
			for(int j = sum; j<arr.length;j++) {
				if(i == arr[j]) {
					count++;
				}
				if(count>0&&i!=arr[j]) {
					break;
				}
			}
			sum += count;
			System.out.println(count);
			count=0;
		}
	}

}
