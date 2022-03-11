/**
  백준 1330번 - 두 수 비교하기
  https://www.acmicpc.net/problem/1330
  
  알고리즘 분류
    1. 수학
    2. 구현
    3. 사칙연산
*/
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());
        System.out.println(num == 0 ? "==" : num > 0 ? ">" : "<");
    }
}
