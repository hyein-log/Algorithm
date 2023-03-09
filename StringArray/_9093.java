package StringArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        while(tc-->0){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            while(st.hasMoreTokens()){
                String str = st.nextToken();
                int n = str.length();
                for(int i=0; i<n; i++){
                    stack.push(str.charAt(i));
                }
                for(int i=0; i<n; i++){
                    sb.append(stack.pop());
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
