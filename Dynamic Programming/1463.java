/**
  백준 1463번 - 1로 만들기
  https://www.acmicpc.net/problem/1463
  
  알고리즘
    1. 다이나믹 프로그래밍
*/

import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int dp[] = new int[number+1];
        for(int i=2; i<=number; i++) {
            dp[i] = dp[i-1] +1;
            if(i%2 == 0) 
                dp[i] = Math.min(dp[i], dp[i/2]+1);
            if(i%3 == 0)
                dp[i] = Math.min(dp[i],  dp[i/3]+1);
        }
        System.out.println(dp[number]);
    }
}
