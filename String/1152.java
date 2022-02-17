/**
  백준 1152번 - 단어의 개수 (StringTokenizer VER.)
  https://www.acmicpc.net/problem/1152
  
  알고리즘 분류
    1. 구현
    2. 문자열
*/
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	System.out.println(st.countTokens());
    }
}
