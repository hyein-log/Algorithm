package _sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11651 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [][] arr = new int[n][2];
		int i=0;
		while(n-->0) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i][0]=x;
			arr[i][1]=y;
			i++;
		}
		Arrays.sort(arr, (a1, a2)->{
			if(a1[1]==a2[1]){
                return a1[0]-a2[0];
            }else{
                return a1[1]-a2[1];
            }
		});
//		
//		for(int a=0; a<arr.length; a++) {
//			for(int b =a ;b<arr.length; b++) {
//				if(arr[a][1] > arr[b][1]) {
//					int temp = arr[a][1];
//					arr[a][1] = arr[b][1];
//					arr[b][1] = temp;
//					int temp1 = arr[a][0];
//					arr[a][0] = arr[b][0];
//					arr[b][0] = temp1;
//					
//				}
//			}
//		}
//		ArrayList<Integer> alist = new ArrayList<>();
//		for(int a=0; a<arr.length; a++) {
//			for(int b =a+1 ;b<arr.length; b++) {
//				if(arr[a][1] == arr[b][1]) {
//					if(!alist.contains(a))
//					alist.add(a);
//					if(!alist.contains(b))
//					alist.add(b);
//					
//				}
//			}
//		}
//		for(int a=0; a<alist.size(); a++) {
//			for(int b =a ;b<alist.size(); b++) {
//				if(arr[alist.get(a)][0] > arr[alist.get(b)][0]) {
//					int temp = arr[alist.get(a)][0];
//					arr[alist.get(a)][0] = arr[alist.get(b)][0];
//					arr[alist.get(b)][0] = temp;
//				}
//			}
//		}
		StringBuilder sb = new StringBuilder();
        for(int o=0; o<n; o++){
            sb.append(arr[o][0]+" "+arr[o][1]).append('\n');
        }
        System.out.println(sb);
//		for(int h=0; h<arr.length; h++) {
//			System.out.println(arr[h][0]+" "+arr[h][1]);
//		}
		
	}

}
