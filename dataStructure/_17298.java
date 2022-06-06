package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//시간초과!
public class _17298 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<Integer>();
		Queue<Integer> q1 = new LinkedList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		while(st.hasMoreTokens()) {
			int u = Integer.parseInt(st.nextToken());
			q1.add(u);
		}
		int x=-1;
		while(n-->0) {
			Iterator<Integer> it = q1.iterator();
			q.clear();
			while(it.hasNext()) {
				q.add(it.next());
			}
			int i=0;
			int a = q.poll();
			q1.poll();
			for(i =0; i<n; i++) {
				if(a<q.peek()) {
					x=q.peek();
					sb.append(x+" ");
					break;
				}else {
					int b = q.poll();
					q.add(b);
				}
			}
			if(i==n) {
				sb.append("-1 ");
			}
		}
		System.out.println(sb);
	}

}
