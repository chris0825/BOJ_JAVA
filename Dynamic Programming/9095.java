/**
  백준 9095번 - 1, 2, 3 더하기
  https://www.acmicpc.net/problem/9095
  
  알고리즘 분류
    1. 다이나믹 프로그래밍
*/
import java.io.*;

public class Main {
    static int dp[] = new int[11];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tC = Integer.parseInt(br.readLine());
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        int n;
        while(tC-- > 0) {
            n = Integer.parseInt(br.readLine());
            bw.write(plus123(n)+"\n");
        }
        bw.close();
    }
    static int plus123(int n) {
        if(dp[n] != 0)
            return dp[n];
        else {
            dp[n] = plus123(n-1) + plus123(n-2) + plus123(n-3);
            return dp[n];
        }
    }
}
