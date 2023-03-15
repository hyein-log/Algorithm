package SamSung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마법사상어와토네이도 {
    static int N;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};   //토네이토의 x 이동 방향
    static int[] dy = {-1, 0, 1, 0};   //토네이토의 y 이동 방향
    static int[] dc = {1, 1, 2, 2};   // 토네이도의 각 방향으로 이동하는 횟수
    static int[][] dsx = {{-1, 1, -2, -1, 1, 2, -1, 1, 0}, {-1, -1, 0, 0, 0, 0, 1, 1, 2},    //모래가 퍼지는 x방향
            {1, -1, 2, 1, -1, -2, 1, -1, 0}, {1, 1, 0, 0, 0, 0, -1, -1, -2}};
    static int[][] dsy = {{1, 1, 0, 0, 0, 0, -1, -1, -2}, {-1, 1, -2, -1, 1, 2, -1, 1, 0},    //모래가 퍼지는 y방향
            {-1, -1, 0, 0, 0, 0, 1, 1, 2}, {1, -1, 2, 1, -1, -2, 1, -1, 0}};
    static int[] sandRatio = {1, 1, 2, 7, 7, 2, 10, 10, 5};

    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine().trim());
        map = new int[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(calculateOutSand(N / 2, N / 2));
    }

    static int calculateOutSand(int x, int y) {
        int totalSand=0;

        int currentX = x;
        int currentY = y;

        while(true){
            for(int d=0; d<4;d++){
                for(int move=0; move < dc[d]; move++){
                    int nextx = currentX + dx[d];
                    int nexty = currentY + dy[d];

                    if(nextx <0 || nexty < 0 || nextx >= N ||nexty >=N){
                        return totalSand;
                    }
                    int sand = map[nextx][nexty];
                    map[nextx][nexty] =0;
                    int spreadTotal = 0;
                    for(int spread =0; spread <9; spread ++){
                        int sandx = nextx+dsx[d][spread];
                        int sandy = nexty+dsy[d][spread];
                        int spreadAmount = (sand*sandRatio[spread])/100;

                        if(sandx < 0|| sandx >=N|| sandy<0 ||sandy >=N){
                            totalSand += spreadAmount;
                        }else{
                            map[sandx][sandy] += spreadAmount;
                        }
                        spreadTotal += spreadAmount;
                    }
                    int ax = nextx+dx[d];
                    int ay = nexty+dy[d];
                    int aAmount = sand - spreadTotal;
                    if(ax <0 || ax>=N || ay<0||ay>=N){
                        totalSand += aAmount;
                    }else{
                        map[ax][ay] += aAmount;
                    }

                    currentX = nextx;
                    currentY = nexty;
                }
            }
            for(int index =0; index <4; index++){
                dc[index] +=2;
            }
        }
    }
}