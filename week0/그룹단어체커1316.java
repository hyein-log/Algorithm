package week0;

import java.util.Scanner;


public class 그룹단어체커1316 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int tc = input.nextInt();
		input.nextLine();
		
		그룹단어체커1316 g = new 그룹단어체커1316();
		
		int count = 0;
		for(int i = 0; i<tc; i++) {
			String str = input.nextLine();
			if(g.check(str)==true) count+=1;
		}
		
		System.out.println(count);
	}
	boolean check(String str) {
		boolean result = true;
		for(int i =0 ; i<str.length()-1; i++) {
			if(str.charAt(i)!=str.charAt(i+1)) {
				String subString = str.substring(0,i);
				String ch = str.charAt(i+1)+"";
				if(subString.contains(ch)) { 
					return false;
				}
				
			}
		}
		return result;
	}

}
