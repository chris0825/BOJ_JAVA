/**
  백준 2579번 - 계단 오르기
  https://www.acmicpc.net/problem/2579
  
  알고리즘 분류
    1. 다이나믹 프로그래밍
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int fNum = Integer.parseInt(br.readLine());
        int stair[] = new int[fNum+1];
        int dp[] = new int[fNum+1];
        for(int i=1; i<=fNum; i++)
            stair[i] = Integer.parseInt(br.readLine());
        dp[1] = stair[1];
        if(fNum >= 2)
            dp[2] = stair[1] + stair[2];
        for(int i=3; i<=fNum; i++)
            dp[i] = Math.max(dp[i-2], dp[i-3] + stair[i-1]) + stair[i];
        System.out.println(dp[fNum]);
    }
}
