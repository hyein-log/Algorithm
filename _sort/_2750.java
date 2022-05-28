package _sort;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2750 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[10001];
		for (int i = 0; i < n; i++) {
			A[Integer.parseInt(br.readLine())]++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10001; i++) {
			while (A[i] > 0) {
				sb.append(i).append('\n');
				A[i]--;
			}
		}
		System.out.print(sb);
	}
}
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class _2750 {
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
////		Scanner scan = new Scanner(System.in);
////		int n = scan.nextInt();
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(br.readLine());
//		int[] arr = new int[n];
//		for(int i=0; i<n; i++) {
//			arr[i] = Integer.parseInt(br.readLine());
//		}
//		Arrays.sort(arr);
//		for(Integer a : arr) {
//			System.out.println(a);
//		}
//	}
//
//}
