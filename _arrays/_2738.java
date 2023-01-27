package _arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2738 {
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        while(st.hasMoreTokens()){
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
        }
        int[][] A = new int[n][m];
        int[][] B = new int[n][m];
        int a = n;
        int b = m;
        for(int i = 0; i <a;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<b; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i <a;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<b; j++){
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i <a;i++){
            for(int j =0; j<b; j++){
                System.out.print(A[i][j]+B[i][j]+" ");
            }
            System.out.println();
        }
    }
}
