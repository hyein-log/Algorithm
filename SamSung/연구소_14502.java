package SamSung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소_14502 {
    static  int N;
    static  int M;
    static int max=0;
    static int[]dx = {0, 1, 0, -1};
    static int[]dy ={1, 0, -1, 0};
    static boolean [][]visited;
    static int Max;
    static int[][] map;
    static int[][] temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        temp = new int[N][M];
        visited = new boolean[N][M];
        Max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(Max);
    }

    public static void dfs(int depth){
        if(depth == 3){
            bfs();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 ) {
                    map[i][j] = 1;
                    dfs(depth+1);
                    map[i][j]=0;
                }
            }
        }
    }
    private static void bfs() {
        Queue<Virus> viruses = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, temp[i], 0, M);
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(temp[i][j]==2){
                    Virus virus = new Virus(i,j);
                    viruses.add(virus);
                }
            }
        }
        visited = new boolean[N][M];
        while(!viruses.isEmpty()){
            Virus now = viruses.poll();
            visited[now.x][now.y] = true;
            for(int i=0; i<4; i++){
                int nextX = now.x+dx[i];
                int nextY = now.y+dy[i];
                if(nextX <0 || nextX >=N || nextY <0 || nextY >=M || visited[nextX][nextY]){
                    continue;
                }
                if(temp[nextX][nextY]==0){
                    temp[nextX][nextY] =2;
                    visited[nextX][nextY] = true;
                    viruses.add(new Virus(nextX,nextY));
                }
            }
        }
        max = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(temp[i][j] ==0)
                    max++;
            }
        }
        if(max>Max){
            Max = max;
        }
    }
    private static class Virus {
        int x;
        int y;
        public Virus(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
