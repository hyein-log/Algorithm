package StringArray;

import java.util.Scanner;

public class _2675 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		while(testcase-- >0) {
			int n = scan.nextInt();
			String str = scan.next();
			char[] arr = new char[n*str.length()];
			char[] arr1 = new char[str.length()];
			for(int i=0; i<arr1.length; i++) {
				arr1[i]=str.charAt(i);
			}int a =0,i=0;
			
			while(i<arr.length) {
				for(int j=0; j<n; j++) {
					arr[i++] = arr1[a];
				}
				a++;	
			}
			for(char c :arr) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
}
