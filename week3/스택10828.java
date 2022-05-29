package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ω∫≈√10828 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> alist = new ArrayList<>();
		while(n-->0) {
			String request[] = br.readLine().split(" ");
			switch (request[0]) {
			case "push": 
				alist = push(Integer.parseInt(request[1]),alist);
				break;
			case "pop": 
				alist = pop(alist);
				break;
			case "size": 
				size(alist);
				break;
			case "empty": 
				empty(alist);
				break;
			case "top": 
				top(alist);
				break;
			default:
				break;
			}
		}
	}

	private static void top(ArrayList<Integer> alist) {
		if(alist.isEmpty()) System.out.println(-1);
		else {
			System.out.println(alist.get(alist.size()-1));
		}
	}

	private static void empty(ArrayList<Integer> alist) {
		System.out.println(alist.isEmpty()? 1: 0);
	}

	private static void size(ArrayList<Integer> alist) {
		System.out.println(alist.size());
	}

	private static ArrayList<Integer> pop(ArrayList<Integer> alist) {
		if(alist.isEmpty()) {
			System.out.println(-1);
		}else {
			System.out.println(alist.get(alist.size()-1));
			alist.remove(alist.size()-1);
		}
		return alist;
		
	}

	private static ArrayList<Integer>  push(int n, ArrayList<Integer> alist) {
		alist.add(n);
		return alist;
	}

}
