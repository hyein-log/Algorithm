package _selfmethod;

import java.io.*;

public class _10872{
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        int a =1;
        if(n!=0) {
        do{
            a =a*n;
        }while(n-- >1);
        }
       System.out.println(a);
    }
}