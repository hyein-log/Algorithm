package SamSung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 퇴사_14501 {
    static int N, max = Integer.MIN_VALUE;
    static int date[];
    static int value[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        date = new int[N];
        value = new int[N];

        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine()," ");
            date[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);

        System.out.println(max);
    }

    static void dfs(int day,int sum){
        //Stack<Integer> stack = new Stack<>();
        //int flag = 0;

        if(day >= N){
            max = Math.max(sum,max);
            return;
        }
        if(day + date[day] <= N){
            dfs(day + date[day], sum+value[day]);
        }else{
            dfs(day+date[day], sum);
        }

        dfs(day+1,sum);


        /*while(day <= N){

            if(day>0 && day+date[day-1] > N){
                while(!stack.empty()) {
                    int ti = stack.pop();
                    sum += value[ti];
                }
                if(max<sum){
                    max = sum;
                }
                flag += 1;
                day = flag;
                sum =0;
            }
            else {
                stack.push(day);
                day += date[day];
            }
        }*/
    }
}
