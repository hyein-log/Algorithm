package _InOut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _10991 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			for (int j = n - i; j > 1; j--) {
				System.out.print(" ");
			}
			System.out.print("*");
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
