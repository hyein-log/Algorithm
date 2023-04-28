package SamSung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 어항정리_23291 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int [][] arr;
    static boolean[][] visited;
    static int N, K , min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        visited = new boolean[N][N];
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++){
            arr[0][i] = Integer.parseInt(st.nextToken());
            visited[0][i] = true;
        }
        for(int i=0; i<N; i++) {
            max = Math.max(max, arr[0][i]);
            min = Math.min(min, arr[0][i]);
        }
        while(max-min > K){
            System.out.println();
            System.out.println();
            System.out.println();
            organize_first();

            organize_second();

            count++;

            System.out.println("count====="+count);
        }

        System.out.println(count);
    }

    static void organize_first(){

        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            visited[0][i] = true;
        }
        //물고기 한마리 넣음
        int m = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            if(arr[0][i]<m){
                m = arr[0][i];
            }
        }
        for(int i=0; i<N; i++){
            if(arr[0][i] == m){
                arr[0][i] += 1;
            }
        }

        System.out.println("====물고기 넣음=====");
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        //어항 쌓음
         /*   1 1
            2 1
            2 2
            3 2
            3 3
            4 3
            4 4
            5 4*/
        int x = 1, y=1 , start=1;
        boolean flag = true;

        while(((start + x) - 1) < N){
            for(int i=0; i<x; i++){
                for(int j=start-y; j<start; j++){
                    arr[start-j][start+i] = arr[i][j];
                    arr[i][j] = 0;
                    visited[start-j][start+i] = true;
                    visited[i][j] = false;
                }
            }
            start+=x;

            if(!flag){
                flag = true;
                y++;
            }else{
                flag = false;
                x++;
            }

        }
        System.out.println("====어항 쌓음=====");
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        //물고기 수 조절
        int[][] temp = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j]==0){
                    continue;
                }
                for(int d=0; d<4; d++){
                    int nextx = i + dx[d];
                    int nexty = j + dy[d];
                    if(nextx <0 ||nextx>=N ||nexty <0 ||nexty >=N || !visited[nextx][nexty]){
                        continue;
                    }

                    int diff = arr[i][j] - arr[nextx][nexty];
                    if(diff < 0){
                        continue;
                    }
                    if(diff / 5 > 0 ){
                        temp[nextx][nexty] += Math.abs(diff / 5) ;
                        temp[i][j] -= Math.abs(diff / 5) ;
                    }
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j] == false){
                    continue;
                }
                arr[i][j] += temp[i][j];
            }
        }

        System.out.println("====물고기 조절=====");
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        //다시 일렬로 정렬
        int d=0;
        int[] map = new int[N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(d>=N){
                    break;
                }
                if(arr[j][i] != 0) {
                    map[d] = arr[j][i];
                    arr[j][i] = 0;
                    d++;
                }
            }
        }
        for(int i=0; i<N; i++){
            arr[0][i] = map[i];
        }

        System.out.println("====재정렬=====");
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void organize_second(){

        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            visited[0][i] = true;
        }
        //공중 부양 작업 두번째
        for(int i=0; i<N/4; i++){
            arr[1][N-1-i] = arr[0][i];
            arr[0][i] = 0;
            visited[0][i] = false;
            visited[1][N-1-i] = true;
        }

        for(int i=0; i<N/4; i++){
            arr[2][N/4*3+i] = arr[0][N/4+i];
            arr[0][N/4+i] = 0;
            visited[0][N/4+i] = false;
            visited[2][N/4*3+i] = true;
        }

        for(int i=0; i<N/4; i++){
            arr[3][N-1-i] = arr[0][N/2+i];
            arr[0][N/2+i] = 0;
            visited[0][N/2+i] = false;
            visited[3][N-1-i] = true;
        }
        System.out.println("====어항 쌓음 두번째=====");
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        //물고기 작업
        int[][] temp = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j]==0){
                    continue;
                }
                for(int d=0; d<4; d++){
                    int nextx = i + dx[d];
                    int nexty = j + dy[d];
                    if(nextx <0 ||nextx>=N ||nexty <0 ||nexty >=N || !visited[nextx][nexty]){
                        continue;
                    }

                    int diff = arr[i][j] - arr[nextx][nexty];
                    if(diff < 0){
                        continue;
                    }
                    if(diff / 5 > 0 ){
                        temp[nextx][nexty] += diff / 5 ;
                        temp[i][j] -= diff / 5 ;
                    }
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                arr[i][j] += temp[i][j];
            }
        }
        System.out.println("====물고기 작업=====");
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        //일렬로 놓음
        int d=0;
        int[] map = new int[N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(d>=N){
                    break;
                }
                if(arr[j][i] != 0) {
                    map[d] = arr[j][i];
                    arr[j][i] = 0;
                    d++;
                }
            }
        }
        for(int i=0; i<N; i++){
            arr[0][i] = map[i];
        }
        System.out.println("====최종 정렬=====");
        for(int i=0; i<N; i++){

                System.out.print(arr[0][i]+" ");

        }
        System.out.println();
        //최대 최소 구하기
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            max = Math.max(max,arr[0][i]);
            min = Math.min(min,arr[0][i]);
        }
    }
}
