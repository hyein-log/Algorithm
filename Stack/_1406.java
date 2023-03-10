package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int tc = Integer.parseInt(br.readLine());
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for(int i=0; i<str.length(); i++){
            stack1.push(str.charAt(i));
        }
        while(tc-->0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char order = st.nextToken().charAt(0);
            char ch = 0;
            if(st.hasMoreTokens()) {
                ch = st.nextToken().charAt(0);
            }
            switch(order){
                case 'P':
                    stack1.push(ch);
                    break;
                case 'L':
                    if(stack1.empty())
                        break;
                    stack2.push(stack1.pop());
                    break;
                case 'D':
                    if(stack2.empty())
                        break;
                    stack1.push(stack2.pop());
                    break;
                case 'B':
                    if(stack1.empty())
                        break;
                    stack1.pop();
                    break;
            }
        }
        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
        while(!stack2.empty()){
            sb.append(stack2.pop());
        }
        System.out.println(sb);
    }
}
