package StringArray;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class _1157 {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		String str = scan.next();
		char[] arr = str.toUpperCase().toCharArray();
		Set<Character> set = new HashSet<>();
		for(Character c : arr) {
		set.add(c);
		}
		char[] arr1 = new char[set.size()];
		Iterator<Character> it = set.iterator();
		while(it.hasNext()) {
			for(int i=0; i<set.size(); i++) {
				arr1[i] = it.next();
			}
		}
		int [] count = new int[set.size()];
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr1.length; j++) {
				if(arr[i]==arr1[j]) {
					count[j]+=1;
				}
			}
		}
		int max=0;
		for(int i=0; i<count.length; i++) {
			if(max<count[i])
				max=count[i];
		}
		int n =0, m=0;
		for(int i=0; i<count.length; i++) {
			if(count[i]==max) {
				n++;
				m=i;
			}
		}
		if(n>1)
			System.out.println("?");
		else
			System.out.println(arr1[m]);
	}
}
