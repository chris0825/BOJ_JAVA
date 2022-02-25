/**
  백준 17626번 - Four Squares
  https://www.acmicpc.net/problem/17626
  
  알고리즘 분류
    1. 다이나믹 프로그래밍
    2. 브루트포스 알고리즘
*/
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int dp[] = new int[Integer.parseInt(br.readLine())+1];
        for(int i=1; i<dp.length; i++) {
            dp[i] = dp[i-1] +1;
            for(int j=1; j*j<=i; j++)
                dp[i] = Math.min(dp[i], dp[i - j*j]+1);
        }
        System.out.println(dp[dp.length-1]);
    }
}
