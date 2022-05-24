package StringArray;

import java.util.*;
public class _11720{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int sum =0;
        String line = scan.next();
        for(int i =0; i<t; i++){
            sum+= line.charAt(i)-'0';
        }
        System.out.println(sum);
    }
}