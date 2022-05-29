package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ÁÂÇ¥¾ÐÃà18870{

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");
		int[] nums = new int[n];
		for(int i = 0; i<arr.length; i++) {
			nums[i] = Integer.parseInt(arr[i]);
		}
		ArrayList<Integer> alist = new ArrayList<>();
		for(int i = 0; i<nums.length; i++) {
			alist.add(nums[i]);
		}
		alist.sort((a,b)->a-b);
		for(int i =0; i<alist.size()-1; i++) {
			if(alist.get(i).equals(alist.get(i+1))) {
				alist.remove(i);
				i--;
			}
		}
		int[] counts = new int[n];
	
		for(int i = 0; i<n; i++) {
			for(int j= 0; j<alist.size(); j++) {
				if(nums[i]!=alist.get(j)) {
					counts[i] = j;
					break;
				}
			}
		}
		for(int i = 0; i<counts.length; i++) {
			if(i==counts.length-1) {
				sb.append(counts[i]);
			}else {
				sb.append(counts[i]+" ");
			}
			
		}
		System.out.println(sb);
	}

}
