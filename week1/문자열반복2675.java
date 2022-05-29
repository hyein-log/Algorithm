package week1;

import java.util.Scanner;

public class 문자열반복2675 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int tc = scanner.nextInt();
		while(tc-->0) {
			int r = scanner.nextInt();
			String str = scanner.next();
			String result = "";
			for(int i = 0; i<str.length(); i++) {
				for(int j = 0; j<r; j++) {
					result+=str.charAt(i);
				}
			}
			System.out.println(result);
		}
	}

}
