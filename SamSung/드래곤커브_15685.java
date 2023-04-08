package SamSung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 드래곤커브_15685 {
    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        boolean [][]map = new boolean[101][101];
        Queue<dragon> dragons = new LinkedList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            dragon dragon = new dragon(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            dragons.add(dragon);
        }
        while(!dragons.isEmpty()){
            dragon now = dragons.poll();
            ArrayList<Integer> directions = new ArrayList<>();
            directions.add(now.d);
            while(now.g-- >0){
                for(int i=directions.size() -1; i>=0; i--){
                    int direction = (directions.get(i)+1)%4;
                    directions.add(direction);
                }
            }
            map[now.x][now.y] = true;
            for(int direc : directions){
                now.x +=dx[direc];
                now.y +=dy[direc];
                map[now.x][now.y] = true;
            }
        }

        int cnt =0;
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]){
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
    public static class dragon{
        int x;
        int y;
        int d;
        int g;
        public dragon(int x, int y, int d, int g){
            this.x =y;
            this.y = x;
            this.d = d;
            this.g = g;
        }
    }
}
