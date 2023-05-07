package SamSung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연산자끼워넣기_14888_1 {
    static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int a = 0;
    static  int[] A;
    //+ - * /
    static int[] operator;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        operator = new int[4];
        visited = new boolean[4];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }
            bfs(0,a,A[0],visited);



        System.out.println(max);
        System.out.println(min);
    }

    static void bfs(int depth, int oper , int sum, boolean[] visited){
        visited = new boolean[4];
        if(depth >= N-1){
            if(max < sum){
                max = sum;
            }
            if(min > sum ){
                min = sum;
            }
            return;
        }
        for(int i=0; i<4; i++) {

            if (operator[i] > 0) {

                    int ss = sum;
                    operator[i] -= 1;
                    switch (i) {
                        case 0:
                            sum += A[depth + 1];
                            break;
                        case 1:
                            sum -= A[depth + 1];
                            break;
                        case 2:
                            sum *= A[depth + 1];
                            break;
                        case 3:
                            sum /= A[depth + 1];
                            break;
                    }
                    bfs(depth + 1, i, sum, visited);

                    operator[i] += 1;

                    sum = ss;

            }
        }
    }

}
