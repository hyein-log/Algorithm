package SamSung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 주사위굴리기2_23288 {
    static int[][] map;
    static boolean [][] visited;
    static int[] value = new int[1000];
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int score, N,M,k, X, Y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j =0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        start(k);

        System.out.println(score);
    }

    public static void start(int k){
        Queue<jsw> queue = new LinkedList();
        queue.add(new jsw(2,4,1,3,5,6, 0,0,1,0,0));
        int B ;
        while(!queue.isEmpty()){
            visited = new boolean[N][M];
            int C = 1;
            jsw now = queue.poll();
            if(now.cnt > k){
                for(int i=0; i<k; i++){
                    score += value[i];
                }
                break;
            }
            int dX = now.xd;
            int dY = now.yd;
            int n = now.cnt;
            if(X + dx[dX] <0 || X + dx[dX] >=N ||Y+dy[dY]<0 ||Y+dy[dY]>=M ){
                if(dX +2 > 3){
                    dX = dX -2;
                    dY = dY -2;
                }
                else {
                    dX = dX + 2;
                    dY = dY + 2;
                }
            }
            B = map[X + dx[dX]][Y+dy[dY]];
            visited[X + dx[dX]][Y+dy[dY]] = true;

            Queue<BFS> bfs = new LinkedList();
            bfs.add(new BFS(X + dx[dX], Y+dy[dY]));
            while(!bfs.isEmpty()) {
                BFS present = bfs.poll();
                int bfsX = present.x;
                int bfsY = present.y;

                for (int i = 0; i < 4; i++) {
                    int nextx = bfsX + dx[i];
                    int nexty = bfsY + dy[i];

                    if (nextx < 0 || nextx >= N || nexty < 0 || nexty >= M) {
                        continue;
                    }

                    if (visited[nextx][nexty] == true || map[nextx][nexty] != B) {
                        continue;
                    }
                    if (visited[nextx][nexty] == false && map[nextx][nexty] == B) {
                        visited[nextx][nexty] = true;
                        C+=1;
                        bfs.add(new BFS(nextx, nexty));
                    }
                }
            }

            value[n-1] = B*C;
            if(dX == 0 && dY ==0) {
                int xd =0, yd= 0;
                X = now.x + dx[xd];
                Y = now.y + dy[yd];
                if(now.d > B){
                    xd = dX+1;
                    yd = dY+1;
                }else if(now.d < B){
                    if(dX-1 <0 ||dY -1 <0){
                        xd = 3;
                        yd = 3;
                    }else {
                        xd = dX - 1;
                        yd = dY - 1;
                    }
                }
                queue.add(new jsw(now.a, now.f, now.b, now.c, now.e, now.d, xd, yd, now.cnt+1, X,Y));
            }else if(dX==1 && dY ==1){
                int xd =1, yd= 1;
                X = now.x + dx[dX];
                Y = now.y + dy[dY];
                if(now.e > B){
                    xd = dX+1;
                    yd = dY+1;
                }else if(now.e < B){
                    xd = dX-1;
                    yd = dY-1;
                }
                queue.add(new jsw(now.f, now.b, now.a, now.d, now.c, now.e, xd, yd, now.cnt+1, X, Y));
            }else if(dX==2 && dY ==2){
                int xd =2, yd= 2;
                X = now.x + dx[dX];
                Y = now.y + dy[dY];
                if(now.b > B){
                    xd = dX+1;
                    yd = dY+1;
                }else if(now.b < B){
                    xd = dX-1;
                    yd = dY-1;
                }
                queue.add(new jsw(now.a, now.c, now.d, now.f, now.e, now.b, xd, yd, now.cnt+1, X,Y));
            }else{
                int xd =3, yd= 3;
                X = now.x + dx[dX];
                Y = now.y + dy[dY];
                if(now.a > B){
                    xd = dX-3;
                    yd = dY-3;
                }else if(now.a < B){
                    xd = dX-1;
                    yd = dY-1;
                }
                queue.add(new jsw(now.c, now.b, now.e, now.d, now.f, now.a, xd, yd, n+1,X,Y));
            }
        }
    }
    static class jsw{
        int cnt;
        int x;
        int y;
        int xd;
        int yd;
        int a;
        int b;
        int c;
        int d;
        int e;
        int f;
        public jsw(int a, int b, int c, int d, int e, int f,int xd, int yd, int cnt, int x, int y){
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.xd = xd;
            this.yd = yd;
        }
    }
    static class BFS{
        int x;
        int y;
        public BFS(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}