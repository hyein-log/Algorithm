package StringArray;

import java.util.Scanner;

public class _1316 {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k=0;
		while(n-->0) {
			boolean result = true;
			String str = scan.next();
			char arr[] = str.toCharArray();
			if(arr.length==1) {
				k++;
				continue;
			}
			for(int i=0; i<arr.length-1; i++) {
				if(!result)
					break;
				if(arr[i+1] != arr[i]) {
					for(int j=0; j<i; j++) {
						if(arr[j]==arr[i+1]) {
							result = false;
							break;	
						}
					}
				}
				if(i==arr.length-2&& result) {
					k++;
				}
			}
		}
		System.out.println(k);
		scan.close();
	}
}
