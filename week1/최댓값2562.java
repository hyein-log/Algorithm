package week1;

import java.util.Scanner;

public class ÃÖ´ñ°ª2562 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int max = 0;
		int count = 0;
		for(int i = 0; i<9; i++) {
			int num = scanner.nextInt();
			if(max<num) {
				max= num;
				count = i+1;
			}
			if(i==8){
				System.out.println(max);
				System.out.println(count);
			}
		}
	}

}
