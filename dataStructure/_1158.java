package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n =Integer.parseInt(st.nextToken());
		int k =Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++) {
			q.add(i);
		}
		while(n-->0) {
			for(int i=1; i<k; i++){
			q.add(q.poll());
			}
			sb.append(q.poll());
			if(n!=0) {
				sb.append(", ");
			}
			
		}
	    System.out.println("<"+sb+">");
	}

}
