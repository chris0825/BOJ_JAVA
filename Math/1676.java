/**
  백준 1676번 - 팩토리얼 0의 개수
  https://www.acmicpc.net/problem/1676﻿
  
  알고리즘 분류
    1. 수학
    2. 임의 정밀도 / 큰 수 연산
*/
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        while(n >= 5)
            cnt += (n/=5);
        System.out.println(cnt);
    }
}
