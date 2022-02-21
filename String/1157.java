/**
  백준 1157번 - 단어 공부
  https://www.acmicpc.net/problem/1157
  
  알고리즘 분류 
    1. 구현
    2. 문자열
*/
import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int apb[] = new int[26];
        String str = input.next();
        str = str.toUpperCase();
        for(int i=0; i<str.length(); i++)
            apb[str.charAt(i)-'A']++;
        int max = 0, ans=0;
        for(int i=0; i<apb.length; i++){
            if(max < apb[i]){
                max = apb[i];
                ans = i;
            }
            else if(max == apb[i])
                ans = -2;
        }
        System.out.printf("%s", Character.toString(ans+'A'));
    }
}
