/**
  백준 11053번 - 가장 긴 증가하는 부분 수열
  https://www.acmicpc.net/problem/11053﻿
  
  알고리즘 분류
    1. 다이나믹 프로그래밍
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int arr[] = new int[size];
        int dp[] = new int[size];
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            for(int j=i; j>=0; j--)
                if(arr[i] > arr[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max+1);
    }
}
