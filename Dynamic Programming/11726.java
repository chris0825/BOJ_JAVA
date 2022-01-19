/**
  백준 11726번 - 2xn 타일링
  https://www.acmicpc.net/problem/11726﻿
  
  알고리즘 분류
    1. 다이나믹 프로그래밍
*/
import java.util.*;  
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[1001];
        dp[1] = 1; // 2X1 타일로 채우는 한 가지 방법 존재
        dp[2] = 2; // 2X1 타일 2개 또는, 2X1타일 2개로 채우는 두 가지 방법 존재
        for(int i=3; i<=n; i++)
            dp[i] = (dp[i-1] + dp[i-2])%10007; // 같은 패턴의 반복이므로 이전 경우의 수 더하면 됨
        System.out.println(dp[n]);
    }
}
