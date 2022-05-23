package _selfmethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10870 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result = fibonacci(n);
		System.out.println(result);
	}

	private static int fibonacci(int n) {
		if(n==1||n ==0) return n;
		
		return fibonacci(n-1)+fibonacci(n-2);
	}

}
