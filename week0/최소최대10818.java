package week0;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;



public class 최소최대10818 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i = 0; i<n; i++) {
			nums.add(input.nextInt());
		}
		int max = nums.stream().max((a,b)->a-b).orElseThrow(NoSuchElementException::new);
		int min = nums.stream().min((a,b)->a-b).orElseThrow(NoSuchElementException::new);
		System.out.println(min+" "+max);
	}

}
