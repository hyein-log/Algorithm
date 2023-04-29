package SamSung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 로봇청소기_14503 {
    static int N, M, count;
    static int[][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        /*
        1.현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
        2.현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
            1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
            2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
        3.현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
            1. 반시계 방향으로 90도 회전한다.
            2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
            3. 1번으로 돌아간다.
         */

        Robot robot = new Robot(r,c,d,0);
        Queue<Robot> queue = new LinkedList<>();
        queue.add(robot);

        while(!queue.isEmpty()){
            Robot now = queue.poll();
            int currentX = now.x;
            int currentY = now.y;
            int dirc = now.d;
            if(map[currentX][currentY] == 0){
                count++;
                map[currentX][currentY] =2;
            }
            int isnt_Clean =0;
            for(int i=0; i<4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                if(nextX<0 || nextX >= N || nextY < 0 ||nextY >=M || map[nextX][nextY] != 0){
                    continue;
                }
                isnt_Clean++;
            }

            // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
            if(isnt_Clean == 0){
                int temp_dirc = now.d + 2;
                if(temp_dirc > 3){
                    temp_dirc -= 4;
                }
                int nextX = currentX + dx[temp_dirc];
                int nextY = currentY + dy[temp_dirc];
                if(nextX<0 || nextX >= N || nextY < 0 ||nextY >=M || map[nextX][nextY] == 1){
                    break;
                }
                queue.add(new Robot(nextX,nextY,dirc,count));
            }else{
                for(int i=0; i<4; i++){
                    dirc = dirc -1;
                    if(dirc < 0){
                        dirc = 3;
                    }
                    int nextX = currentX + dx[dirc];
                    int nextY = currentY + dy[dirc];
                    if(map[nextX][nextY] == 0){
                        queue.add(new Robot(nextX,nextY,dirc,count));
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }

    static class Robot{
        int x;
        int y;
        int count;
        int d;

        public Robot(int x, int y, int d, int count){
            this.x = x;
            this.y = y;
            this.d = d;
            this.count = count;
        }

    }
}
