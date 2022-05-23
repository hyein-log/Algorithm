package _InOut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Scanner;

public class _10992 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			for (int j = n - i; j > 1; j--) {
				System.out.print(" ");
			}
			if (i==0||i == n - 1) {
				System.out.print(String.join("", Collections.nCopies(i * 2 + 1, "*")));
			} 
			else {
				for (int a = 0; a < i * 2 + 1; a++) {
					if (a == 0 || a == i * 2) {
						System.out.print("*");
						continue;
					}
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}

