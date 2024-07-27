package For_While;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _25304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long final_price  = Long.parseLong(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int array[]  = new int[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int amount = Integer.parseInt(st.nextToken());
            array[i] = price*amount;
        }
        int arrayAll =0;
        for(int i=0; i<N; i++){
            arrayAll += array[i];
        }

        if(arrayAll == final_price){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
