package _InOut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _3003 {
    public static void main(String[] args) throws IOException {

        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(1);
        arr2.add(1);
        arr2.add(2);
        arr2.add(2);
        arr2.add(2);
        arr2.add(8);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        while(st.hasMoreTokens()){
            int a = Integer.parseInt(st.nextToken());
            arr.add(a);
        }
        int size = arr2.size();
        while(size-- > 0) {
            int n = arr.get(size);
            arr.remove(size);
            arr.add(size, n - arr2.get(size));
        }
        size = arr.size();
        while(size-- > 0){
            int num = arr.get(arr.size()-(size+1));
            if(num == 0){
                continue;
            }
            else{
                arr.add(arr.size()-(size+1),num*-1);
                arr.remove(arr.size()-(size+1));
            }
        }
        for(int i =0; i<arr.size(); i++){
            System.out.print(arr.get(i)+" ");
        }
    }
}
