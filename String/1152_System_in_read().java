/**
  백준 1152번 - 단어의 개수 (System.in.read() VER.)
  https://www.acmicpc.net/problem/1152
  
  알고리즘 분류
    1. 구현
    2. 문자열
*/
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        int input, prev = 32, cnt = 0;
        while(true) {
            input = System.in.read();
            if(input == 32){
                if(prev != 32)
                    cnt++;
            }
            else if(input == 10) {
                if(prev != 32)
                    cnt++;
                break;
            }
            prev = input;
        }
        System.out.println(cnt);
    }
}
