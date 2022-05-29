package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ÆÑÅä¸®¾ó10872 {
	static int i =1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nString = br.readLine();
		int n = Integer.parseInt(nString);
		int facN = factorial(n);
		System.out.println(facN);
	}

	private static int factorial(int n) {
		if(n>0) {
			i *=n;
			n--;
			return factorial(n);
		}
		else return i;
		
		
	}

}
