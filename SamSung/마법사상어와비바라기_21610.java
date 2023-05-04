package SamSung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마법사상어와비바라기_21610 {
    static int N,M;
    static int [][] A;
    //←, ↖, ↑, ↗, →, ↘, ↓, ↙
    static int dx[] = {0,-1,-1,-1,0,1,1,1};
    static int dy[] = {-1,-1,0,1,1,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<N; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        while(M-- >0){
            st = new StringTokenizer(br.readLine()," ");
            int di = Integer.parseInt(st.nextToken());
            int si = Integer.parseInt(st.nextToken());

            cloudMove(di,si);
            waterPlus();
            cloudReset();
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

    }
}
