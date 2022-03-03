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
        int tC = Integer.parseInt(br.readLine());
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        StringBuilder sb = new StringBuilder();
        while(tC-- > 0)
            sb.append(plus123(Integer.parseInt(br.readLine()))+"\n");
        System.out.println(sb);
    }
    static int plus123(int n) {
        return dp[n] != 0 ? dp[n] : (dp[n] = plus123(n-1) + plus123(n-2) + plus123(n-3));
    }
}
