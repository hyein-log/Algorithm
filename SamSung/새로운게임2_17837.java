package SamSung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 새로운게임2_17837 {
    static int N, K, turn=0;
    static int[][] map;
    static int[][] Hmap;
    static int[][]relation;
    static Queue<Horse> queue;
    //→, ←, ↑, ↓
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        Hmap = new int[N][N];
        relation = new int[K+1][K+1];
        //0은 흰색, 1은 빨간색, 2는 파란색이다
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        queue = new LinkedList<>();
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            Horse horse = new Horse(x-1,y-1,d-1, i+1);
            queue.add(horse);
            Hmap[x-1][y-1] = i+1;
        }

        Game();

        System.out.println(turn);
    }

    static void Game(){
        while(true) {
            if (turn >= 1000) {
                turn = -1;
                return;
            }
            for (int i = 1; i <= K; i++) {
                int count = dp(i, 1);
                if (count >= 4) {
                    turn = count;
                    return;
                }
            }

            for (int i = 0; i < K; i++) {
                Horse now = queue.poll();
                int nextX = now.x + dx[now.d];
                int nextY = now.y + dy[now.d];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
                    if (now.d == 0) {
                        now.d += 1;
                    } else if (now.d == 1) {
                        now.d = 0;
                    } else if (now.d == 2) {
                        now.d += 1;
                    } else {
                        now.d = 2;
                    }
                    nextX = now.x + dx[now.d];
                    nextY = now.y + dy[now.d];
                }

                if (map[nextX][nextY] == 0) {
                    if (Hmap[nextX][nextY] != 0) {
                        relation[Hmap[nextX][nextY]][now.num] = 1;
                    }
                    Hmap[nextX][nextY] = now.num;
                    Hmap[now.x][now.y] =0;
                    queue.add(new Horse(nextX, nextY, now.d, now.num));
                } else if (map[nextX][nextY] == 1) {
                    cross(now.num, nextX, nextY);
                    Hmap[now.x][now.y] =0;
                    queue.add(new Horse(nextX, nextY, now.d, now.num));
                } else {
                    if (now.d == 0) {
                        now.d += 1;
                    } else if (now.d == 1) {
                        now.d = 0;
                    } else if (now.d == 2) {
                        now.d += 1;
                    } else {
                        now.d = 2;
                    }
                    nextX = now.x + dx[now.d];
                    nextY = now.y + dy[now.d];

                    if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || map[nextX][nextY] == 2) {
                        queue.add(new Horse(now.x, now.y, now.d, now.num));
                        break;
                    }
                    if (map[nextX][nextY] == 0) {
                        if (Hmap[nextX][nextY] != 0) {
                            relation[Hmap[nextX][nextY]][now.num] = 1;
                        }
                        Hmap[nextX][nextY] = now.num;
                        Hmap[now.x][now.y] =0;
                        queue.add(new Horse(nextX, nextY, now.d, now.num));
                    } else if (map[nextX][nextY] == 1) {
                        cross(now.num, nextX, nextY);
                        Hmap[now.x][now.y] =0;
                        queue.add(new Horse(nextX, nextY, now.d, now.num));
                    }
                }
            }
            turn += 1;
        }
    }
    static void cross(int num, int x, int y){
        int i=0;
        for(i=0; i<K+1; i++){
            if(relation[num][i]>0){
                relation[num][i] = 0;
                cross(i, x, y);
                relation[i][num] = 1;
                Hmap[x][y] = num;
                break;
            }
        }
        if(i == K+1) {
            if(Hmap[x][y]>0) {
                relation[Hmap[x][y]][num] = 1;
            }else{
                Hmap[x][y] = num;
            }
        }
    }
    static int dp(int k,int count){
        int c = 0;
        for(int i=1; i<K+1; i++){
            if(relation[k][i] > 0){
                dp(i,count+1);
                c = count+1;
                break;
            }else if(i==K && relation[k][i] == 0){
                break;
            }else{
                continue;
            }
        }
        return c;
    }
    static class Horse{
        int x;
        int y;
        int d;
        int num;

        Horse(int x, int y, int d, int num){
            this.x = x;
            this.y = y;
            this.d = d;
            this.num = num;
        }
    }
}
