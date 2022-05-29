package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ≈Î∞Ë«–2108 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		double sum = 0;
		int avg = 0;
		int center = 0;
		int fre = 0;
		int range = 0;
		ArrayList<Integer> arrayList = new ArrayList<>();
		ArrayList<Integer> alist = new ArrayList<>();
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		if(n == 1) {
			avg = arr[0];
			center = arr[0];
			fre = arr[0];
			range = 0;
		}
		else {
			avg =(int)Math.round((sum/n)*10/10);
			Arrays.sort(arr);
			center = arr[Math.round(n/2)];
			
			int max = 0;
			int count = 0;
			
			for(int i = 0; i<arr.length; i++) {
				count++;
				if(i == arr.length-1) {
					arrayList.add(count);
				}
				else if(arr[i]!=arr[i+1]) {
					arrayList.add(count);
					count = 0;
				}
				
			}
			
			for(int i = 0; i<arrayList.size()-1; i++) {
				if(arrayList.get(i)<arrayList.get(i+1)) {
					alist.clear();
					sum = 0;
					for(int j = 0; j<i+1; j++) {
						sum += arrayList.get(j);
					}
					fre = arr[(int)sum];
				}else if(arrayList.get(i)==arrayList.get(i+1)) {
					sum = 0;
					for(int j = 0; j<i; j++) {
						sum+=arrayList.get(j);
					}
					alist.add(arr[(int)sum]);
					alist.add(arr[(int)sum+arrayList.get(i+1)]);
				}else {
					alist.clear();
					sum = 0;
					for(int j = 0; j<i; j++) {
						sum += arrayList.get(j);
					}
					fre = arr[(int)sum];
				}
			}
			range = arr[n-1]-arr[0];
		}
		sb.append(avg+"\n");
		sb.append(center+"\n");
		sb.append(alist.isEmpty()? fre+"\n":alist.get(1)+"\n");
		sb.append(range+"\n");
		System.out.println(sb);
	}

}
