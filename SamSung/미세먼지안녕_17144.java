package SamSung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미세먼지안녕_17144 {
    static int[] dx_R = {0,1,0,-1};
    static int[] dy_R = {1,0,-1,0};
    static int[] dx_L = {0,-1,0,1};
    static int[] dy_L = {1,0,-1,0};
    static int map[][];
    static int R, C, T, air_top_x, air_buttom_x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        int dust_Sum =0;
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int top=0;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j] ==-1){
                    if(top==0){
                        air_top_x = i;
                        top++;
                    }else{
                        air_buttom_x = i;
                    }
                }
            }
        }
        for(int i=0; i<T; i++){
            map[air_top_x][0] =-1;
            map[air_buttom_x][0] =-1;
            dust(map);

            air(air_top_x, air_buttom_x);
        }
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j]>0){
                    dust_Sum += map[i][j];
                }
            }
        }
        System.out.println(dust_Sum);
    }

    public static void dust(int[][] map ){
        int[][] temp = new int[R][C];
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j]>0){
                    int count=0;
                    int value = map[i][j] / 5;
                    if(value<1){
                        temp[i][j] += map[i][j];
                        continue;
                    }
                    for(int d=0; d<4; d++){
                        int nextX = i + dx_R[d];
                        int nextY = j + dy_R[d];
                        if(nextX>=0 && nextX<R && nextY>=0 && nextY <C){
                            if((nextX == air_top_x || nextX == air_buttom_x) && nextY ==0){
                                continue;
                            }
                            temp[nextX][nextY] += value;
                            count++;
                        }
                    }
                    temp[i][j] += map[i][j] - value*count;
                }else{
                    temp[i][j] += map[i][j];
                }
            }
        }
        // temp map 출력
        for(int i=0; i<R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(temp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("============");
        for(int i=0; i<R; i++){
            System.arraycopy(temp[i], 0, map[i], 0, C);
        }
    }

    public static void air(int topx,int butmx){
        int [][] temp = new int[R][C];

        for(int i=0; i<4; i++){
            int nextX, nextY;
            if (i == 0) {
                nextX = topx;
                nextY = 0;
                for(int j=1; j<C; j++){
                    nextY = nextY+dy_L[i];
                    if(nextY==C-1){
                        if(nextX-1 >= 0){
                            temp[nextX-1][nextY] = map[nextX][nextY];
                            break;
                        }else{
                            break;
                        }
                    }
                    temp[nextX][nextY+1] = map[nextX][nextY];
                }
            }else if(i==1){
                nextX = topx;
                nextY = C-1;
                for(int j=0; j<topx; j++){
                    nextX = nextX+dx_L[i];
                    if(nextX == 0){
                        if(nextY-1 >= 0){
                            temp[nextX][nextY-1] = map[nextX][nextY];
                            break;
                        }else{
                            break;
                        }
                    }
                    temp[nextX-1][nextY] = map[nextX][nextY];
                }
            }else if(i==2){
                nextX = 0;
                nextY = C-1;
                for(int j=1; j<C; j++){
                    nextY = nextY+dy_L[i];
                    if(nextY == 0){
                        if(nextX+1 < R && air_top_x !=nextX+1){
                            temp[nextX+1][nextY] = map[nextX][nextY];
                            break;
                        }else{
                            break;
                        }
                    }
                    temp[nextX][nextY-1] = map[nextX][nextY];
                }
            }else{
                nextX = 1;
                nextY = 0;
                for(int j=0; j<topx; j++){
                    nextX = nextX+dx_L[i];
                    if(nextX >= topx){
                        continue;
                    }
                    temp[nextX+1][nextY] = map[nextX][nextY];
                }
            }
        }
        for(int i=0; i<=topx; i++) {
            for (int j = 0; j < C; j++) {
                if(i>0 && i<=topx-1 && j >0 && j<C-1){
                    continue;
                }
                if(temp[i][j] != map[i][j]){
                    map[i][j] = temp[i][j];
                }
            }
        }

        for(int i=0; i<4; i++){
            int nextX, nextY;
            if (i == 0) {
                nextX = butmx;
                nextY = 0;
                for(int j=1; j<C; j++){
                    nextY = nextY+dy_R[i];
                    if(nextY==C-1){
                        if(nextX+1 < R){
                            temp[nextX+1][nextY] = map[nextX][nextY];
                            break;
                        }else{
                            break;
                        }
                    }
                    temp[nextX][nextY+1] = map[nextX][nextY];
                }
            }else if(i==1){
                nextX = butmx;
                nextY = C-1;
                for(int j=butmx; j<R; j++){
                    nextX = nextX+dx_R[i];
                    if(nextX == R-1){
                        if(nextY-1 >= 0){
                            temp[nextX][nextY-1] = map[nextX][nextY];
                            break;
                        }else{
                            break;
                        }
                    }
                    temp[nextX+1][nextY] = map[nextX][nextY];
                }
            }else if(i==2){
                nextX = R-1;
                nextY = C-1;
                for(int j=1; j<C; j++){
                    nextY = nextY+dy_R[i];
                    if(nextY == 0){
                        if(nextX-1 > 0 && air_buttom_x !=nextX-1){
                            temp[nextX-1][nextY] = map[nextX][nextY];
                            break;
                        }else{
                            break;
                        }
                    }
                    temp[nextX][nextY-1] = map[nextX][nextY];
                }
            }else{
                nextX = R-1;
                nextY = 0;
                for(int j=butmx; j<R; j++){
                    nextX = nextX+dx_R[i];
                    if(nextX-1 <= butmx){
                        continue;
                    }
                    temp[nextX-1][nextY] = map[nextX][nextY];
                }
            }
        }
        for(int i=butmx; i<R; i++) {
            for (int j = 0; j < C; j++) {
                if(i>butmx && i<=R-2 && j >0 && j<C-1){
                    continue;
                }
                if(temp[i][j] != map[i][j]){
                    map[i][j] = temp[i][j];
                }
            }
        }
        /*System.out.println();
        System.out.println("=== air=========");
        for(int i=0; i<R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("=====air=======");*/
    }
}
