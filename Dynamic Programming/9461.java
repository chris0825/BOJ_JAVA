/**
  백준 9461번 - 파도반 수열 (실버 3)
  https://www.acmicpc.net/problem/9461﻿
  
  알고리즘 분류
    1. 수학
    2. 다이나믹 프로그래밍
*/
import java.io.*;

public class Main {
    static long dp[] = new long[101];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        dp[1] = dp[2] = dp[3] = 1;
        while(t-- > 0)
            bw.write(wave(Integer.parseInt(br.readLine()))+"\n");
        bw.close();
    }
    static long wave(int n) {
        if(dp[n] == 0)
            dp[n] = wave(n-2) + wave(n-3);
        return dp[n];
    }
}
