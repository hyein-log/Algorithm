package week1;

import java.util.Scanner;

public class ¾ËÆÄºªÃ£±â10809 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		for(char i = 'a'; i<='z'; i++) {
			for(int j = 0; j<string.length(); j++) {
				if(string.charAt(j)==i) {
					System.out.print(j+" ");
					break;
				}
				else {
					if(j==string.length()-1) {
						System.out.print(-1+" ");
					}
				}
			}
		}
	}

}
