package _arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2566 {
    static int n = 9, m =9 , max = 0, x,y;
    public static void main(String[] args) throws IOException {
        int[][] arr = new int[n][m];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i =0; i<9; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i =0; i<9; i++){
            for(int j =0; j<9; j++){
                if(arr[i][j]>=max){
                    max = arr[i][j];
                    x = i+1;
                    y = j+1;
                }
            }
        }
        System.out.println(max);
        System.out.println(x+" "+y);
    }
}
