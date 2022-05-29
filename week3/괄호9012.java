package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class °ýÈ£9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i<n; i++) {
			String[] arr = br.readLine().split("");
			ArrayList<Integer> aList = new ArrayList<>();
			for(int j = 0; j<arr.length; j++) {
				if(arr[j].equals("(")) {
					aList.add(0);
				}else {
					aList.add(1);
				}
			}
			String result = checkArr(aList);
			System.out.println(result);
		}
	}

	private static String checkArr(ArrayList<Integer> aList) {
		if(aList.size()==0) {
			return "YES";
		}else {
			for(int i = 0; i<aList.size(); i++) {
				if(aList.get(i)==1) {
					if(i==0) {
						return "NO";
					}
					else if(aList.get(i-1)==0) {
						aList.remove(i);
						aList.remove(i-1);
						break;
					}else {
						return "NO";
					}
					
				}else if(i==aList.size()-1) {
					return "NO";
				}
			}
			return checkArr(aList);
		}
		
	}

}
