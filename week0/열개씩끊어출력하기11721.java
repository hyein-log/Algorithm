package week0;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class 열개씩끊어출력하기11721 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char[] arr = input.next().toCharArray();
		ArrayList<Character> aList = new ArrayList<Character>();
//		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
//		bReader.read();
		for(char c: arr) {
			aList.add(c);
		}
		Iterator<Character> it = aList.iterator();
		while(it.hasNext()) {
			String str ="";
			for(int i = 0; i<10; i++) {
				if(it.hasNext()) {
					str+= it.next();
				}
				else break;
				
			}
			System.out.println(str);
		}
	}

}
