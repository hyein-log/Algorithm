package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for(int i=tc; i>0; i--){
            stack2.push(i);
        }
        while(tc-->0){
            int n = Integer.parseInt(br.readLine());
            if(!stack2.empty() && stack2.peek()<=n) {
                for(int i=stack2.peek(); i<=n; i++) {
                    sb.append("+").append("\n");
                    stack1.push(stack2.pop());
                }
            }
            if(!stack1.empty() && stack1.peek()==n){
                sb.append("-").append("\n");
                stack1.pop();
            }
            else{
                if(stack1.peek() > n ){
                    sb.setLength(0);
                    sb.append("NO");
                    break;
                }
                for(int i=stack1.peek(); i>=n; i--){
                    sb.append("-").append("\n");
                    stack1.pop();
                }
            }
        }
        System.out.println(sb);
    }
}
