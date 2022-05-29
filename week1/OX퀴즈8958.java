package week1;

import java.util.Scanner;

public class OXÄûÁî8958 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int tc = scanner.nextInt();
		scanner.nextLine();
		while(tc-->0) {
			String string = scanner.nextLine();
			int count = 0;
			int sum = 0;
			for(int i = 0; i<string.length(); i++) {
				if(string.charAt(i)=='O') {
					count++;
					sum+=count;
				}else {
					count = 0;
				}
			}
			System.out.println(sum);
		}
	}

}
