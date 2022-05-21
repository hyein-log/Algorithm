package _arrays;

import java.util.Scanner;

public class _8958 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test-->0) {
			String str = scan.next();
			char[] arr = str.toCharArray();
			int n =0;
			int count=0;
			for(int i=0; i<arr.length; i++) {
				if(arr[i]=='O') {
					n++;
					count += n;
				}else {
					n=0;
				}
			}
			System.out.println(count);
		}
	}

}
