package _selfmethod;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class _11729 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int start =1;
		int mid = 2;
		int end = 3;
		System.out.println((int)(Math.pow(2, n)-1));
		f(n, start,mid, end);
		bw.flush();
		bw.close();
//		f5 ->1+f4
//		start->mid f4
//		start->end 1
//		f4 = 1+f3
//		start->mid f3
//		start->end 1
//		f3 = 1+f2
//		start->mid f2
//		start->end 1
//		f2-> 1+f1
//		start->mid f1
//		start->end 1
//		f1 => 1
//		start->end
//		
	}

	private static void f(int n, int start, int mid, int end) throws IOException {
		if(n==1) {
			bw.write(start+" "+end+"\n");
			return ;
		}
			n--;
			f(n,start, end, mid);
			bw.write(start+" "+end+"\n");
			f(n,mid, start,end);
	}
}
