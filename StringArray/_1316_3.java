package StringArray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1316_3 {
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            String str = br.readLine();
            if(group(str)) {
                result++;
            }
        }
        System.out.println(result);
    }
    public static boolean group(String str){
        boolean result = true;
        String[] arr = str.split("");

        for(int i=1; i<arr.length; i++){
            if(!arr[i].equals(arr[i-1])){
                for(int j=0; j<i; j++){
                    if(arr[j].equals(arr[i]))
                        return false;
                }
            }
        }

        return result;
    }
}
