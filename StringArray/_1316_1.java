package StringArray;

import java.util.Scanner;


public class _1316_1 {

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int tc = input.nextInt();
      input.nextLine();
      
      int count = 0;
      for(int i = 0; i<tc; i++) {
         String str = input.nextLine();
         if(check(str)==true) count+=1;
      }
      
      input.close();
      System.out.println(count);
   }
   static boolean check(String str) {
      boolean result = true;
      for(int i =0 ; i<str.length()-1; i++) {
         if(str.charAt(i)!=str.charAt(i+1)) {
            String subString = str.substring(0,i);
            String ch = str.charAt(i+1)+"";
            if(subString.contains(ch)) { 
               return false;
            }
            
         }
      }
      return result;
   }

}