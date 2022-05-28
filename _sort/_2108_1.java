package _sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class _2108_1 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<Integer> alist = new ArrayList<>();
		while(n-->0) {
			alist.add(scan.nextInt());
		}
		Collections.sort(alist);
		Iterator<Integer> it = alist.iterator();
		
		double sum =0;
		
		for(int i=0; i<alist.size(); i++) {
			sum += (int)alist.get(i);
		}
		
		int avg = (int)Math.round(sum/alist.size());
		
		int midnum = Math.round(alist.size()/2);
		int mid = alist.get(midnum);
		
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<alist.size(); i++) {
			set.add(alist.get(i));
		}
		
		int [][] arr = new int[set.size()][2];
		Iterator<Integer> st = set.iterator();
		int stnum=0;
		while(st.hasNext()) {
			arr[stnum][0]= (int)st.next();
			stnum++;
		}
		while(it.hasNext()) {
			int alistnum = (int)it.next();
			for(int i=0; i<arr.length; i++) {
				if(arr[i][0] == alistnum) {
					arr[i][1]++;
					break;
				}
			}
		}
		int max =0;
		ArrayList<Integer> num = new ArrayList<>();
		for(int i=0; i<arr.length; i++) {
			if(max<arr[i][1]) {
				max = arr[i][1];
			}	
		}
		for(int i=0; i<arr.length; i++) {
			if(arr[i][1] ==max) {
				num.add(arr[i][0]);
			}
		}
		int freqnum =0;
		if(num.size()>1) {
		Collections.sort(num);
		freqnum =num.get(1);
		}
		else {
			freqnum=num.get(0);
		}
	
		int range =0;
		if(alist.size()>1) {
		int minnum = alist.get(0);
		int maxnum = alist.get(alist.size()-1);
		range = maxnum-minnum;
		}
		else {
			range = 0;
		}
		int Range = range;

		System.out.println(avg);
		System.out.println(mid);
		System.out.println(freqnum);
		System.out.println(Range);
	}

}
