package SamSung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경사로_14890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int [][] map  = new int[N][N];
        boolean [][] visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        //가로 검사
        for(int i=0; i<N; i++){
            visited = new boolean[N][N];
            int temp = map[i][0];
            int j = 0;
            for(j=0; j<N-1; j++){
                if(map[i][j+1] == map[i][j]){
                    continue;
                }
                if(map[i][j+1] != map[i][j]){
                    temp = map[i][j];
                    if(map[i][j+1] - map[i][j] == 1 && j+1-L>=0) {
                        int x =0;
                        for(x =0; x <L; x++){
                            if(map[i][j-x] == temp && visited[i][j-x] ==false){
                                continue;
                            }else{
                                break;
                            }
                        }
                        if(x==L){
                            for(x =0; x <L; x++){
                                visited[i][j-x] = true;
                            }
                            continue;
                        }
                        else{
                            break;
                        }
                    }else if(map[i][j+1] - map[i][j] == 1 && j+1-L < 0){
                        break;
                    }else if(map[i][j] - map[i][j+1] == 1 && j+L<N){
                        temp = map[i][j+1];
                        int x =0;
                        for(x =0; x <L; x++){
                            if(map[i][j+1+x] == temp && visited[i][j+1+x] ==false){
                                continue;
                            }else{
                                break;
                            }
                        }
                        if(x==L){
                            for(x =0; x <L; x++){
                                visited[i][j+1+x] = true;
                            }
                            continue;
                        }
                        else{
                            break;
                        }
                    }else if(map[i][j] - map[i][j+1] == 1 && j+L >= N){
                        break;
                    }else{
                        break;
                    }
                }
            }
            if(j==N-1){
                cnt++;
            }
        }
        //세로 검사
        for(int i=0; i<N; i++){
            visited = new boolean[N][N];
            int temp = map[0][i];
            int j = 0;
            for(j=0; j<N-1; j++){
                if(map[j+1][i] == map[j][i]){
                    continue;
                }
                if(map[j+1][i] != map[j][i]){
                    temp = map[j][i];
                    if(map[j+1][i] - map[j][i] == 1 && j+1-L>=0) {
                        int x =0;
                        for(x =0; x <L; x++){
                            if(map[j-x][i] == temp&& visited[j-x][i] ==false){
                                continue;
                            }else{
                                break;
                            }
                        }
                        if(x==L){
                            for(x =0; x <L; x++){
                                visited[j-x][i] = true;
                            }
                            continue;
                        }
                        else{
                            break;
                        }
                    }else if(map[j+1][i] - map[j][i] == 1 && j-L < 0){
                        break;
                    }else if(map[j][i] - map[j+1][i] == 1 && j+L<N){
                        temp = map[j+1][i];
                        int x =0;
                        for(x =0; x <L; x++){
                            if(map[j+1+x][i] == temp&& visited[j+1+x][i] ==false){
                                continue;
                            }else{
                                break;
                            }
                        }
                        if(x==L){
                            for(x =0; x <L; x++){
                                visited[j+1+x][i] = true;
                            }
                            continue;
                        }
                        else{
                            break;
                        }
                    }else if(map[j][i] - map[j+1][i] == 1 && j+L >= N){
                        break;
                    }else{
                        break;
                    }
                }
            }
            if(j==N-1){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
