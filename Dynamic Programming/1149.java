/**
  백준 1149번 - RGB거리 (실버 4)
  https://www.acmicpc.net/problem/1149﻿
  
  알고리즘 분류
    1. 다이나믹 프로그래밍
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dp[][] = new int[n+1][3];
        StringTokenizer st;
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            dp[i][0] = Integer.parseInt(st.nextToken()) + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = Integer.parseInt(st.nextToken()) + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = Integer.parseInt(st.nextToken()) + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        System.out.println(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));
    }
}
