/**
  백준 1929번 - 소수 구하기
  https://www.acmicpc.net/problem/1929
  
  알고리즘 분류
    1. 수학
    2. 정수론
    3. 소수 판정
    4. 에라토스테네스의 체
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        boolean pN[] = new boolean[n+1];
        pN[1] = true;
        for(int i=2; i*i<=n; i++)
            if(!pN[i])
                for(int j=i*i; j<=n; j+=i)
                    pN[j] = true;
        StringBuilder sb = new StringBuilder();
        for(int i=m; i<=n; i++)
            if(!pN[i])
                sb.append(i+"\n");
        System.out.println(sb);
    }
}
