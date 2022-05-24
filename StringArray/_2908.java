package StringArray;

import java.util.Scanner;

public class _2908{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		int a = scan.nextInt();
		int b = scan.nextInt();
		scan.close();
		for(int i=0; i<3; i++) {
			sb1.append(a%10);
			a= a/10;
			sb2.append(b%10);
			b=b/10;
		}
		String aa = sb1.toString();
		String bb = sb2.toString();
	
		if(aa.compareTo(bb)>0)
			System.out.println(sb1);
		else
			System.out.println(sb2);
	}

}
