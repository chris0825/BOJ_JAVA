/**
  백준 1003번 - 피보나치 함수
  https://www.acmicpc.net/problem/1003
  
  알고리즘
    1. 다이나믹 프로그래밍
*/
import java.io.*;

public class Main {
    static int dp[][] = new int[41][2];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tC = Integer.parseInt(br.readLine());
        while(tC-- > 0){
            int fibo[] = fibonacci(Integer.parseInt(br.readLine()));
            bw.write(fibo[0]+" "+fibo[1]+"\n");
        }
        bw.close();
    }
    static int[] fibonacci(int n) {
        if(n <= 1)
            dp[n][n] = 1;
        else if(dp[n][0] == 0 && dp[n][1] == 0) {
            dp[n][0] = fibonacci(n-1)[0] + fibonacci(n-2)[0];
            dp[n][1] = fibonacci(n-1)[1] + fibonacci(n-2)[1];
        }
        return dp[n];
    }
}
