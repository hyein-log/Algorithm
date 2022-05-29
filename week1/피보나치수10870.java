package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 피보나치수10870 {
	static int i = 2;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nString = br.readLine();
		int n = Integer.parseInt(nString);
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(1);
		int result = makeResult(n, list);
		System.out.println(result);
	}

	private static int makeResult(int n, ArrayList<Integer> list) {
		if(i<=n) {
			list.add(list.get(i-1)+list.get(i-2));
			i++;
			return makeResult(n, list);
		}
		else {
			return list.get(n);
		}
		
	}

}
