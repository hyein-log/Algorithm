package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0){
            int size =0;
            boolean flag = true;
            char[] array = br.readLine().toCharArray();
            for(int i=0; i<array.length; i++){
                if(array[0] == ')'){
                    sb.append("NO").append("\n");
                    flag=false;
                    break;
                }
                else if(array[i]=='('){
                    size+=1;
                }else{
                    size-=1;
                    if(size<0){
                        sb.append("NO").append("\n");
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) {
                if (size == 0) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
