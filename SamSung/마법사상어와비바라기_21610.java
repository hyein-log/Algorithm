package SamSung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class 마법사상어와비바라기_21610 {
    static int N,M;
    static int [][] A;
    //←, ↖, ↑, ↗, →, ↘, ↓, ↙
    static int dx[] = {0,-1,-1,-1,0,1,1,1};
    static int dy[] = {-1,-1,0,1,1,1,0,-1};
    static boolean[][] cloud_is;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        cloud_is = new boolean[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<N; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cloud_is[N-1][0] = true;
        cloud_is[N-1][1] = true;
        cloud_is[N-2][0] = true;
        cloud_is[N-2][1] = true;


        while(M-- >0){
            st = new StringTokenizer(br.readLine()," ");
            int di = Integer.parseInt(st.nextToken());
            int si = Integer.parseInt(st.nextToken());

            cloudMove(di,si);
            waterPlus();
            //cloudReset();
            waterCopyMagic();
            cloudCreate();

        }
        int sum =0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(A[i][j]>0){
                    sum += A[i][j];
                }
            }
        }
        System.out.println(sum);
    }

    static void cloudMove(int di, int si){
        int x = dx[di-1];
        int y = dy[di-1];

        boolean[][] temp_cloud = new boolean[N][N];
        boolean[][] copy_cloud = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                temp_cloud[i][j] = cloud_is[i][j];
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(temp_cloud[i][j]){
                    int nextX = i;
                    int nextY = j;

                    for(int k=0; k<si; k++){
                        nextX += x;
                        nextY += y;
                        if(nextX >= N){
                            nextX = nextX % N;
                        }else if(nextX < 0){
                            nextX = N-1;
                        }
                        if(nextY >= N){
                            nextY = nextY % N;
                        }else if(nextY < 0){
                            nextY = N-1;
                        }

                    }

                    //cloud_is[i][j] = false;
                    copy_cloud[nextX][nextY] = true;
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                cloud_is[i][j] = copy_cloud[i][j];
            }
        }

    }
    static void waterPlus(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(cloud_is[i][j]){
                    A[i][j] += 1;
                }
            }
        }
    }

    static void waterCopyMagic(){
        int [] dx = {-1,-1,1,1};
        int [] dy = {-1,1,1,-1};
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(cloud_is[i][j]){
                    int count = 0;
                    for(int k=0; k<4; k++){
                        int nextX = i+dx[k];
                        int nextY = j+dy[k];
                        if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N){
                            continue;
                        }
                        if(A[nextX][nextY] > 0){
                            count++;
                        }
                    }
                    A[i][j] += count;
                }
            }
        }
    }

    static void cloudCreate(){
        boolean temp[][] = new boolean[N][N];

        for(int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                temp[i][j] = cloud_is[i][j];
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!temp[i][j] && A[i][j] >= 2){
                    cloud_is[i][j] = true;
                    A[i][j] -= 2;
                }
                else if(temp[i][j]){
                    cloud_is[i][j] = false;
                }
            }
        }
    }
}
