package SamSung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 게리맨더링2_17779 {
    static int gap =0;
    static int max;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int A[][] = new int[N][N];
        int visited[][] = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j =0; j<N; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        max = Integer.MAX_VALUE;
        Queue<trial> trials = new LinkedList<>();
        int x, y, d1, d2;
        for(int i=1; i<N-1; i++){
            x = i;
            for(int j = 1; j <= N-i-1; j++){
                d1 = j;
                for(int k = 1; k <= N - j - i; k++ ){
                    d2 = k;
                    for(int c = 2; c<=N-d2; c++){
                        y =c;
                        if(y-d1>=1 && y-d1<y && y<y+d2 && y+d2<=N){
                            trial triri = new trial(x,y,d1,d2);
                            trials.add(triri);
                        }
                    }
                }
            }
        }

        while(!trials.isEmpty()){
            visited = new int[N][N];
            trial now = trials.poll();
            x = now.x;
            y = now.y;
            d1 = now.d1;
            d2 = now.d2;

            int one = 0, two = 0, three = 0, four =0 , five=0;

            for(int i=x-1; i<= x+d1+d2; i++){
                for(int j=y-1; j<N; j++){

                }
            }

            //1번 선거구
            flag = false;
            int cut = 0;
            for(int i=0; i<x+d1-1; i++){
                int r = i;
                for(int j = 0; j<y; j++){
                    int c = j;
                    if(r == x+cut-1 && c == y-cut-1) {
                        cut++;
                        break;
                    }else{
                        one += A[r][c];
                        visited[r][c] = 1;
                    }
                }
            }
            //2번 선거구
            int yy = y;
            cut =0;
            for(int i=0; i<x+d2; i++){
                int r = i;
                for(int j = yy; j<N; j++){
                    int c = j;
                    if(r == x+cut && c == y+cut) {
                        yy++;
                        cut++;
                        continue;
                    }else{
                        two += A[r][c];
                        visited[r][c] = 2;
                    }
                }
            }
            //3번 선거구
            cut = 0;
            flag = false;
            for(int i=x+d1-1; i<N; i++){
                int r = i;
                for(int j = 0; j<y-d1-1+cut; j++){
                    int c = j;
                    if(c == y-d1+d2-1) {
                        flag = true;
                        continue;
                    }else{
                        three += A[r][c];
                        visited[r][c] = 3;
                    }
                }
                if(!flag) {
                    cut++;
                }
            }
            //4번 선거구
            flag = false;
            cut = -1;
            for(int i=x+d2; i<N; i++){
                int r = i;
                if(!flag){
                    cut++;
                }
                for(int j = y+d2-1-cut; j<N; j++){
                    int c = j;
                    if(r-1 == x+d1+d2-1 && c == y-d1+d2-1) {
                        flag = true;
                        four += A[r][c];
                        visited[r][c] = 4;
                    }else{
                        four += A[r][c];
                        visited[r][c] = 4;
                    }
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(visited[i][j] == 0){
                        five += A[i][j];
                    }
                }
            }
            int m =0;
            int M =0;
            M = Math.max(Math.max(Math.max(Math.max(one,two),three),four),five);
            m = Math.min(Math.min(Math.min(Math.min(one,two),three),four),five);
            gap = M-m;

            if(max>gap){
                max = gap;
            }
        }

        System.out.println(max);
    }
    static class trial{
        int x;
        int y;
        int d1;
        int d2;

        public trial(int x, int y, int d1, int d2){
            this.x = x;
            this.y = y;
            this.d1 = d1;
            this.d2 = d2;
        }
    }
}
