/**
  백준 1152번 - 단어의 개수
  https://www.acmicpc.net/problem/1152
  
  알고리즘 분류
    1. 구현
    2. 문자열
*/
import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int cnt=0;
        String temp;
        while(input.hasNext()){
            temp = input.next();
            cnt++;
        }
        System.out.println(cnt);
    }
}
