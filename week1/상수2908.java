package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class »ó¼ö2908 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		String[] arr = new String[2];
		for(int i = 0; i<2; i++) {
			String str = st.nextToken();
			String newstr = "";
			for(int j = str.length()-1;j>=0; j--) {
				newstr +=str.charAt(j);
			}
			arr[i] = newstr;
		}
		if(Integer.parseInt(arr[0])>Integer.parseInt(arr[1]))System.out.println(arr[0]);
		else System.out.println(arr[1]);
	}

}
