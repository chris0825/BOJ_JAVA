/**
  백준 11727번 - 2Xn 타일링2
  https://www.acmicpc.net/problem/11727
  
  알고리즘 분류
    1. 다이나믹 프로그래밍
*/
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[1001];
        dp[1] = 1;
        for(int i=2; i<=n; i++) {
            if(i%2 == 0)
                dp[i] = (dp[i-1]*2+1)%10007;
            else
                dp[i] = (dp[i-1]*2-1)%10007;
        }
        bw.write(String.valueOf(dp[n]));
        bw.close();
    }
}
