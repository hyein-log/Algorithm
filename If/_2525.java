package If;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int takeTime = Integer.parseInt(st.nextToken());

        int temp_minute = minute+takeTime;
        do {
            if (temp_minute > 59) {
                temp_minute -= 60;
                hour++;
            }
            if(hour > 23){
                hour = 0;
            }
        }while (temp_minute > 59);
        minute = temp_minute;
        System.out.println(hour + " " + minute);
    }
}
