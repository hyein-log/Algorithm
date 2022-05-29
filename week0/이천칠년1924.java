package week0;

import java.util.Scanner;

public class ÀÌÃµÄ¥³â1924 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int x = input.nextInt();
		int y = input.nextInt();
		String[] days = {"MON","TUE","WED","THU","FRI","SAT","SUN"};
		String day = null;
		int index = 0;
		for(int i = 1; i<x+1;i++) {
			int date = 31;
			if(i == 2) date = 28;
			else if(i==4||i==6||i==9||i==11) date = 30;
			
			
			for(int j = 1; j<date+1; j++) {
				if(i==x &&j==y) {
					day = days[index];
					System.out.println(day);
					break;
				} 
				else {
					day = days[index];
					index++;
				}
				if(index == days.length)index = 0;
			}
		}
	}

}
