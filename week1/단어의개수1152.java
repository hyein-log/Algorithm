package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 단어의개수1152{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		Scanner scanner = new Scanner(System.in);
//		String[] arr= scanner.nextLine().trim().split(" ");
//		System.out.println(arr.length);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		System.out.println(st.countTokens());
	}

}
