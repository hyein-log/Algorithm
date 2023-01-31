package StringArray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2908_2 {
    static int a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        int A = reverse(a);
        int B = reverse(b);
        int result = Integer.compare(A,B);
        if(result== -1){
            result = B;
        }
        else{
            result = A;
        }
        System.out.println(result);
    }
    public static int reverse(int x){
        int result = 0;
        try {
            String[] reverse = String.valueOf(Math.abs(x)).split("");
            StringBuilder sb = new StringBuilder();
            for(int i=reverse.length-1; i>=0; i--){
                sb.append(reverse[i]);
            }
            result = Integer.parseInt(sb.toString());
        }catch (NumberFormatException e){
            result = 0;
        }
        return result;
    }
}
