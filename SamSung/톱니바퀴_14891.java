package SamSung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 톱니바퀴_14891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [][] gears = new int[4][8];

        for(int i = 0; i<4; i++){
            String str = br.readLine();
            for(int j =0; j<8; j++){
                gears[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        // 톱니바퀴의 2 , 6 번 주의~

        int K = Integer.parseInt(br.readLine());

        for(int k=0; k<K; k++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int gearNum = Integer.parseInt(st.nextToken());
            int direc = Integer.parseInt(st.nextToken());

            //N == 0 , S == 1
            int gear1_2 = gears[0][2];
            //int gear1_6 = gears[0][6];
            int gear2_2 = gears[1][2];
            int gear2_6 = gears[1][6];
            int gear3_2 = gears[2][2];
            int gear3_6 = gears[2][6];
            //int gear4_2 = gears[3][2];
            int gear4_6 = gears[3][6];

            //2번 6번 극의 데이터만 저장되어 있는 배열.
            int[][] gears_sn = new int[4][2];
            gears_sn[0][1] = gear1_2;
            gears_sn[1][0] = gear2_6;
            gears_sn[1][1] = gear2_2;
            gears_sn[2][0] = gear3_6;
            gears_sn[2][1] = gear3_2;
            gears_sn[3][0] = gear4_6;

            boolean[] visited = new boolean[4];
            Gear gear = new Gear(gearNum-1,gears_sn[gearNum-1][1],gears_sn[gearNum-1][0],direc );

            Queue<Gear> queue = new LinkedList<>();
            queue.add(gear);

            while(!queue.isEmpty()){
                Gear now = queue.poll();
                visited[now.gearN] = true;
                for(int i=0; i<2; i++){
                    if(i==0 && now.gearN != 0 && visited[now.gearN-1]==false){
                        if(gears_sn[now.gearN-1][1] != now.num6){
                            queue.add(new Gear(now.gearN-1,gears_sn[now.gearN-1][1], gears_sn[now.gearN-1][0],now.dir*-1 ));
                        }
                    }else if(i==1 && now.gearN != 3 && visited[now.gearN+1]==false){
                        if(gears_sn[now.gearN+1][0] != now.num2){
                            queue.add(new Gear(now.gearN+1,gears_sn[now.gearN+1][1], gears_sn[now.gearN+1][0],now.dir*-1 ));
                        }
                    }
                }

                if(now.dir == -1){
                    int temp = gears[now.gearN][0];
                    for(int i=0; i<7; i++){
                        gears[now.gearN][i] = gears[now.gearN][i+1];
                    }
                    gears[now.gearN][7] = temp;
                }else{
                    int temp = gears[now.gearN][7];
                    for(int i=7; i>0; i--){
                        gears[now.gearN][i] = gears[now.gearN][i-1];
                    }
                    gears[now.gearN][0] = temp;
                }
            }
        }

        int sum = 0;
        for(int i=0; i<4; i++){
            if(gears[i][0]>0){
                sum += Math.pow(2,i);
            }
        }

        System.out.println(sum);
    }

    private static class Gear{
        int num2;
        int num6;
        int dir;
        int gearN;

         Gear(int gearN, int two, int six, int dir){
            this.gearN = gearN;
            this.num2 = two;
            this.num6 = six;
            this.dir = dir;
        }
    }
}
