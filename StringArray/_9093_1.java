package StringArray;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9093_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                String str = st.nextToken();
                char[] array = str.toCharArray();
                for (int i = array.length - 1; i >= 0; i--) {
                    sb.append(array[i]);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
