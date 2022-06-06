package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _17298_1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a=0;
		while(st.hasMoreTokens()) {
			arr[a]=Integer.parseInt(st.nextToken());
			a++;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0; i<n; i++) {
			while(!stack.isEmpty()&&arr[i]>arr[stack.peek()]) {
				arr[stack.pop()] = arr[i];
			}
				stack.push(i);
			
		}
		if(stack.size()!=0) {
			while(!stack.isEmpty()) {
				arr[stack.pop()] = -1;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(Integer num :arr) {
			sb.append(num+" ");
		}
		System.out.println(sb);
	}

}
