package SamSung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 청소년상어_19236 {
    static int[] biX = {-1,-1,0,1,1,1,0,-1};
    static int[] biY = {0,-1,-1,-1,0,1,1,1};
    static int[][] map;
    static int[][] tempMap;
    static int[][] mapD;
    static int[][] tempMapD;
    static int max = 0;
    static int FsharkX, FsharkY, fishX=-1, fishY, fishD, temp_x, temp_y, nextFishX, nextFishY;
    static boolean flag =true;
    static int[] eatFish = new int[16];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        map = new int[4][4];
        mapD = new int[4][4];
        for(int i=0; i<4; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<4; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                mapD[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Move(0,0);
        System.out.println(max);
    }
    static void Move(int x, int y){
        Queue<shark> queue = new LinkedList<>();
        eatFish[map[x][y]-1] = map[x][y];
        int vv = map[x][y];
        map[x][y] =0;
        queue.add(new shark(x, y, vv,eatFish,map,mapD));

        tempMap = new int[map.length][map.length];
        tempMapD = new int[map.length][map.length];

        while(!queue.isEmpty()){
            shark nowShark = queue.poll();

            if(nowShark.fishAmount > max)
                max = nowShark.fishAmount;

            if(nowShark.sharkX +biX[nowShark.sharkD-1]< 0 || nowShark.sharkX +biX[nowShark.sharkD-1] >=4 || nowShark.sharkY +biY[nowShark.sharkD-1] <0 ||nowShark.sharkY +biY[nowShark.sharkD-1] >=4){
                continue;
            }

            for(int i = 0; i < map.length; i++) {
                System.arraycopy(nowShark.fishmap[i], 0, map[i], 0, map.length);
            }
            for(int i = 0; i < map.length; i++) {
                System.arraycopy(nowShark.fishmapd[i], 0, mapD[i], 0, map.length);
            }
            FsharkX = nowShark.sharkX;
            FsharkY = nowShark.sharkY;
            map[FsharkX][FsharkY] =0;
            FishMove(nowShark.fishNum);

            for(int i=1; i<4; i++){
                int nextX = nowShark.sharkX + biX[nowShark.sharkD-1] * i;
                int nextY = nowShark.sharkY + biY[nowShark.sharkD-1] * i;

                if(nextX<0|| nextY < 0 || nextX >= 4 ||nextY >=4){
                    continue;
                }
                if(map[nextX][nextY] == 0){
                    continue;
                }

                int fish = map[nextX][nextY];
                map[nextX][nextY] = 0;
                eatFish = nowShark.fishNum.clone();
                eatFish[fish-1] = fish;
                if(!(nowShark.sharkX +biX[nowShark.sharkD-1]< 0 || nowShark.sharkX +biX[nowShark.sharkD-1] >=4 || nowShark.sharkY +biY[nowShark.sharkD-1] <0 ||nowShark.sharkY +biY[nowShark.sharkD-1] >=4)){
                    queue.add(new shark(nextX, nextY, nowShark.fishAmount + fish, eatFish,map, mapD));
                }

                map[nextX][nextY] = fish;
                eatFish[fish-1] =0;
            }
            for(int j = 0; j < map.length; j++)
                System.arraycopy(nowShark.fishmap[j], 0, map[j], 0, map.length);
            for(int j = 0; j < map.length; j++)
                System.arraycopy(nowShark.fishmapd[j], 0, mapD[j], 0, map.length);
        }
    }

    static class shark{
        int sharkX;
        int sharkY;
        int sharkD;
        int fishAmount;
        int[] fishNum;

        int[][]fishmap = new int[map.length][map.length];
        int[][]fishmapd = new int[map.length][map.length];
         public  shark(int x, int y, int fishAmount, int[] fish,int[][]map, int[][]mapD){
             this.sharkX = x;
             this.sharkY = y;
             this.sharkD = mapD[x][y];
             this.fishAmount =fishAmount;
             this.fishNum = fish.clone();

             for(int i = 0; i < map.length; i++) {
                 System.arraycopy(map[i], 0, this.fishmap[i], 0, map.length);
             }
             for(int i = 0; i < map.length; i++) {
                 System.arraycopy(mapD[i], 0, this.fishmapd[i], 0, map.length);
             }
         }
    }

    static void FishMove(int[] fishNum){

        for(int d=0; d<16; d++){
            if(fishNum[d] == 0){
                for(int i=0; i<4; i++){
                    fishX = -1;
                    for(int j=0; j<4; j++){
                        if(map[i][j] == d+1) {
                            fishX = i;
                            fishY = j;
                            fishD = mapD[fishX][fishY];
                            break;
                        }
                    }
                    if(fishX >= 0){
                        break;
                    }
                }
                nextFishX =fishX + biX[fishD-1];
                nextFishY =fishY + biY[fishD-1];
                if((nextFishX < 0 || nextFishX >=4 ||nextFishY <0 ||nextFishY >=4) || (nextFishX == FsharkX && nextFishY == FsharkY) ){
                    for(int i=0; i<8; i++) {
                        flag = true;
                        fishD++;
                        if (fishD > 8) {
                            fishD = 1;
                        }
                        temp_x = fishX + biX[fishD-1];
                        temp_y = fishY + biY[fishD-1];

                        if((temp_x < 0 ||temp_x >= 4 || temp_y < 0 || temp_y >= 4) || (temp_x == FsharkX && temp_y == FsharkY)){
                            flag = false;
                            continue;
                        }
                        else {
                            mapD[fishX][fishY] = fishD;
                            nextFishX = temp_x;
                            nextFishY = temp_y;
                            break;
                        }
                    }

                }
                if(flag) {
                    int fishA, fishB;
                    int fishAD, fishBD;
                    fishA = map[fishX][fishY];
                    fishAD = mapD[fishX][fishY];
                    fishB = map[nextFishX][nextFishY];
                    fishBD = mapD[nextFishX][nextFishY];
                    map[fishX][fishY] = fishB;
                    mapD[fishX][fishY] = fishBD;
                    map[nextFishX][nextFishY] = fishA;
                    mapD[nextFishX][nextFishY] = fishAD;
                }
            }
        }
    }
}
