package _sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class _2108 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<Integer> alist = new ArrayList<>();
		while(n-->0) {
			alist.add(scan.nextInt());
		}
		Collections.sort(alist);
		avg(alist);
		mid(alist);
		freq(alist);
		range(alist);
		scan.close();
	}

	private static void range(ArrayList<Integer> alist) {
		int range =0;
		if(alist.size()>1) {
		int min = alist.get(0);
		int max = alist.get(alist.size()-1);
		range = max-min;
		}
		else {
			range = 0;
		}
		System.out.println(range);
	}

	private static void freq(ArrayList<Integer> alist) {
		Iterator<Integer> it2 = alist.iterator();
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
		while(it2.hasNext()) {
			int alistnum = (int)it2.next();
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
		if(num.size()>1) {
		Collections.sort(num);
		System.out.println(num.get(1));
		}
		else {
			System.out.println(num.get(0));
		}
	}

	private static void mid(ArrayList<Integer> alist) {
		int a = Math.round(alist.size()/2);
		System.out.println(alist.get(a));
	}

	private static void avg(ArrayList<Integer> alist) {
		Iterator<Integer> it = alist.iterator();
		double sum =0;
		while(it.hasNext()) {
			sum += (int)it.next();
		}
		
		System.out.println((int)Math.round(sum/alist.size()));
		
	}

}
