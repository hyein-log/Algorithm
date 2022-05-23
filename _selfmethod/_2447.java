package _selfmethod;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class _2447 {
	static char[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner scan = new Scanner(System.in);
//		int n = scan.nextInt();
//		scan.close();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		int x = n / 3;
		for (int i = 0; i < n; i += x) {
			for (int j = 0; j < n; j += x) {
				if (i == x && j == x) {
					bin(x, i, j);
					continue;
				}
				star(x, i, j);
			}
		}
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				sb.append(arr[i][j]);
//			}
//			sb.append('\n');
//		}
//		System.out.print(sb);
		for (int i = 0; i < n; i++) {
			bw.write(arr[i]);
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		
	}

	private static void bin(int x, int i, int j) {
		for (int a = i; a < i + x; a++) {
			for (int b = j; b < x + j; b++) {
				arr[a][b] = ' ';
			}
		}
		return;
	}

	private static void star(int x, int i, int j) {

		int v = x / 3;
		if (x == 1) {
			arr[i][j] = '*';
			return;
		} else {
			for (int a = i; a < i + x; a += v) {
				for (int b = j; b < x + j; b += v) {
					if (a == v + i && b == v + j) {
						bin(v, a, b);
						continue;
					}
					star(v, a, b);
				}
			}
		}
		return;
	}
}
