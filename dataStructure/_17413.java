package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class _17413 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Deque<String> q = new LinkedList<String>();
		int i=0, j=0;
		for(i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c=='<') {
				for(j=i;j<str.length(); j++) {
					q.add(String.valueOf(str.charAt(j)));
					if(str.charAt(j)=='>') {
						break;
					}
				}
				i=j-1;
			}
			else if(c=='>') {
				while(q.size()>0) {
					sb.append(q.poll());
				}
			}
			else {
				for(j=i;j<str.length(); j++) {
					if(str.charAt(j)=='<'|| str.charAt(j)==' ') {
						while(q.size()>0) {
							sb.append(q.pollLast());
						}
						if(str.charAt(j)==' ') {
							sb.append(" ");
							j++;
						}
						break;
					}
					q.add(String.valueOf(str.charAt(j)));
				}
				i=j-1;
			}
		}
		if(q.size()>0) {
			while(q.size()>0) {
				sb.append(q.pollLast());
			}
		}
		System.out.println(sb);
	}
}
