package 히든테스트케이스_실패문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 마법사상어와복제_23290 {
    //←, ↖, ↑, ↗, →, ↘, ↓, ↙
    static int[] dx= {0,-1,-1,-1,0,1,1,1};
    static int[] dy= {-1,-1,0,1,1,1,0,-1};
    static int M, S, S_1, sharkX, sharkY;
    static int[][] map, smellMap;
    static Queue<Fish> fishs, temp_fishs;
    static int [] sdx = {-1,0,1,0};
    static int [] sdy = {0,-1,0,1};
    static int fish_all_num, max = Integer.MIN_VALUE;
    static StringBuilder sb = new StringBuilder();
    static String orderby = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        map = new int[4][4];
        smellMap = new int[4][4];
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        S_1 = S;
        fishs = new LinkedList<>();
        temp_fishs = new LinkedList<>();
        while(M-->0){
            st = new StringTokenizer(br.readLine()," ");
            Fish fish = new Fish(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()));
            fishs.add(fish);
            map[fish.x][fish.y] += 1;
            //fish_map[fish.x][fish.y] = fish;
        }
        st = new StringTokenizer(br.readLine()," ");
        Shark shark = new Shark(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1,0);

        sharkX = shark.x;
        sharkY = shark.y;

        while(S-->0) {
            magic();
        }

        int sum=0;
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(map[i][j] > 0) {
                    sum+=map[i][j];
                }
            }
        }

        System.out.println(sum);
    }

    static void magic(){

        copyMagic();
        fishMove();
        sharkMove();
        fishsmell();
        copyMagic_done();
    }
    static void copyMagic(){
        int n = fishs.size();
        for(int i=0; i<n;i++) {
            Fish one = new Fish(fishs.poll());
            temp_fishs.add(one);
            fishs.add(one);
        }
        /*System.out.println("copyMagic---------");
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }*/
    }
    static void fishMove(){

        int fishNum = fishs.size();

        while(fishNum-->0){
            Fish now_fish = fishs.poll();
            boolean flag = false;
            for(int i=0; i<8; i++) {
                int dirc = now_fish.d-i-1;
                if(dirc < 0){
                    dirc += 8;
                }
                int nextX = now_fish.x + dx[dirc];
                int nextY = now_fish.y + dy[dirc];

                if (nextX < 0 || nextX >= 4 || nextY < 0 || nextY >= 4) {
                    continue;
                }
                if(nextX == sharkX && nextY == sharkY){
                    continue;
                }
                if(smellMap[nextX][nextY] > 0){
                    continue;
                }

                map[now_fish.x][now_fish.y] -= 1;
                map[nextX][nextY] += 1;
                fishs.add(new Fish(nextX,nextY, dirc+1));
                flag = true;
                break;
            }
            if(!flag){
                fishs.add(new Fish(now_fish.x, now_fish.y, now_fish.d));
            }
        }
        /*System.out.println("fishMove---------");
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }*/

    }

    static int x1,x2,x3,y1,y2,y3;
    static void sharkMove(){

        int count =0;
        max = Integer.MIN_VALUE;
        orderby = "";
        dfs(count);


        int one, two, three;
        one = Integer.parseInt(String.valueOf(orderby.charAt(0)))-1;
        two = Integer.parseInt(String.valueOf(orderby.charAt(1)))-1;
        three = Integer.parseInt(String.valueOf(orderby.charAt(2)))-1;
        x1 = sharkX + sdx[one];
        y1 = sharkY + sdy[one];

        x2 = x1 + sdx[two];
        y2 = y1 + sdy[two];

        x3 = x2 + sdx[three];
        y3 = y2 + sdy[three];

        if(map[x1][y1] > 0) {
            smellMap[x1][y1] += 3;
            map[x1][y1] = 0;
        }
        if(map[x2][y2] > 0) {
            smellMap[x2][y2] += 3;
            map[x2][y2] = 0;
        }
        if(map[x3][y3] > 0) {
            smellMap[x3][y3] += 3;
            map[x3][y3] = 0;
        }
        sharkX = x3;
        sharkY = y3;
        /*System.out.println("sharkMove---------");
        System.out.println(one+" "+two+" "+three);
        System.out.println("shark.r--"+sharkX+"shark.c --"+sharkY);
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                System.out.print(smellMap[i][j]);
            }
            System.out.println();
        }*/
    }

    static void dfs(int count){

        if(count >= 3){
            bfs(fish_all_num);
            return;
        }
        for(int i=0; i<4; i++){
            int nextX = sharkX + sdx[i];
            int nextY = sharkY + sdy[i];
            if(nextX < 0 ||nextX >=4 || nextY < 0 || nextY >=4){
                continue;
            }
            if(map[nextX][nextY] > 0){
                int fishnum = map[nextX][nextY];
                map[nextX][nextY] = 0;
                //smellMap[nextX][nextY] = 2;
                fish_all_num += fishnum;
                sb.append(i+1);
                int X = sharkX;
                int Y = sharkY;
                sharkX = nextX;
                sharkY = nextY;
                dfs(count+1);
                map[nextX][nextY] = fishnum;
                //smellMap[nextX][nextY] = 0;
                fish_all_num -= fishnum;
                sb.deleteCharAt(sb.length()-1);
                sharkX = X;
                sharkY = Y;
            }else if(map[nextX][nextY] == 0){
                sb.append(i+1);
                int X = sharkX;
                int Y = sharkY;
                sharkX = nextX;
                sharkY = nextY;
                dfs(count+1);
                sb.deleteCharAt(sb.length()-1);
                sharkX = X;
                sharkY = Y;
            }
        }
    }
    static void bfs(int fish_all_num){
        if(max<fish_all_num){
            max = fish_all_num;
            orderby = sb.toString();

        }else if(max == fish_all_num){
            if(Integer.parseInt(orderby) < Integer.parseInt(sb.toString())){
            }else{
                orderby = sb.toString();
            }
        }
    }

    static void fishsmell(){
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(smellMap[i][j] > 0) {
                    smellMap[i][j] -= 1;
                    map[i][j] = 0;
                }
            }
        }
      /*  System.out.println("fishsmell---------");
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                System.out.print(smellMap[i][j]);
            }
            System.out.println();
        }*/
    }

    static void copyMagic_done(){
        int s = fishs.size();

        for(int i=0; i<s; i++) {
            Fish one = fishs.poll();
            if (x1 == one.x && y1 == one.y) {
                continue;
            }
            else if (x2 == one.x && y2 == one.y) {
                continue;
            }
            else if (x3 == one.x && y3 == one.y) {
                continue;
            }
            temp_fishs.add(one);
        }
        map = new int[4][4];
        int n = temp_fishs.size();
        for(int i=0; i<n; i++){
            Fish one = temp_fishs.poll();
            fishs.add(one);
            map[one.x][one.y] += 1;
        }
        /*System.out.println("copyMagic_done---------");
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();*/
    }
    static class Fish{
        int x;
        int y;
        int d;

        Fish(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }

        public Fish(Fish poll) {
            this.x = poll.x;
            this.y = poll.y;
            this.d = poll.d;
        }
    }
    static class Shark{
        int x, y, count;

        Shark(int x, int y, int count){
            this.x = x;
            this.y =y;
            this.count = count;
        }
    }
}
