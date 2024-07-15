package _InOut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class _11382 {
    public static void main(String[] args) throws IOException {
       /* BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        long a = Long.parseLong(strArr[0]);
        long b = Long.parseLong(strArr[1]);
        long c = Long.parseLong(strArr[2]);

        System.out.println(a+b+c);*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        long a = 0l;
        int b = st.countTokens();
        for(int i=0; i<b; i++){
           a += Long.parseLong(st.nextToken());
        }

        System.out.println(a);
    }
}
