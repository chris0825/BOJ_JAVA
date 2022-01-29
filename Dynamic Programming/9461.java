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
        int t = Integer.parseInt(br.readLine()); // 질문할 개수
        dp[1] = dp[2] = dp[3] = 1; // f(x) = f(x-3) + f(x-2)이므로 초기 값 1~3까지 우선 입력
        while(t-- > 0)
            bw.write(wave(Integer.parseInt(br.readLine()))+"\n"); // 결과 출력
        bw.close();
    }
    static long wave(int n) {
        if(dp[n] == 0) // 아직 탐색이 안된 경우
            dp[n] = wave(n-2) + wave(n-3); // 점화식, 계산하면서 배열에 저장하여 나중에 연산없이 호출하여 사용할 수 있도록
        return dp[n]; // 배열에 저장된 값 반환
    }
}
