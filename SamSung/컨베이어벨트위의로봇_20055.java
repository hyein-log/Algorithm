package SamSung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 컨베이어벨트위의로봇_20055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int belt[] = new int[N*2];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N*2; i++){
            belt[i] = Integer.parseInt(st.nextToken());
        }
        boolean robot[] = new boolean[N];
        int answer =1;
        while(true) {
            //벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
            int temp = belt[N*2-1];
            for(int i=N*2-1; i>0; i--){
                belt[i] = belt[i-1];
            }
            belt[0] = temp;

            for(int i=N-2; i>=0; i--){
                robot[i+1] = robot[i];
            }
            robot[0] = false;

            if(robot[N-1]){
                robot[N-1] = false;
            }

            //가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
            //로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
            for(int i=N-2; i>=0; i--){
                if(robot[i+1] == false && belt [i+1] >0 && robot[i]){
                    robot[i+1] = robot[i];
                    robot[i] = false;
                    belt[i+1]--;
                }
            }
            if(robot[N-1]){
                robot[N-1] = false;
            }

            //올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
            if(belt[0]>0){
                robot[0] = true;
                belt[0]--;
            }

            int cnt=0;
            //내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
            for(int i=0; i<N*2; i++){
                if(belt[i] == 0){
                    cnt ++;
                }
                if(cnt >= K){
                    System.out.println(answer);
                    return;
                }
            }
            answer ++;
        }
    }
}
