package dataStructure;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10828 {
	public static int[] A;
	public static int size = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		A = new int[n];

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			switch (st.nextToken()) {

			case "push":
				push(Integer.parseInt(st.nextToken()));
				break;

			case "pop":
				sb.append(pop()).append('\n');
				break;

			case "size":
				sb.append(size()).append('\n');
				break;

			case "empty":
				sb.append(empty()).append('\n');
				break;

			case "top":
				sb.append(top()).append('\n');
				break;
			}

		}
		System.out.println(sb);
	}

	public static void push(int item) {
		A[size] = item;
		size++;
	}

	public static int pop() {
		if (size == 0) {
			return -1;
		} else {
			int res = A[size - 1];
			A[size - 1] = 0;
			size--;
			return res;
		}
	}

	public static int size() {
		return size;
	}

	public static int empty() {
		if (size == 0) {
			return 1;
		} else {
			return 0;
		}
	}

	public static int top() {
		if (size == 0) {
			return -1;
		} else {
			return A[size - 1];
		}
	}
}
