package _InOut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _1924 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int [] monthdays = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
		String[] dayname = new String[] {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		int days =0;
		for(int i=0; i<m-1; i++) {
			days += monthdays[i];
		}
		System.out.println(dayname[(days + d)%7]) ;
		
//		Scanner scan = new Scanner(System.in);
//		int m = scan.nextInt(); 
//		int d = scan.nextInt();
//		scan.close();
//		int [] monthdays = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
//		String[] dayname = new String[] {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
//		int days =0;
//		for(int i=0; i<m-1; i++) {
//			days += monthdays[i];
//		}
//		System.out.println(dayname[(days + d)%7]) ;
	}

}
