package StringArray;

import java.util.Scanner;
import java.util.StringTokenizer;

public class _1152 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		StringTokenizer st = new StringTokenizer(str," ");
		int a =0;
		while(st.hasMoreTokens()) {
			st.nextToken();
			a++;
		}
		System.out.println(a);
		System.out.println(st.countTokens());
	}
}
