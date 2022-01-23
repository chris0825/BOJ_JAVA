/**
  백준 2606번 - 바이러스(Recursion Ver.)
  https://www.acmicpc.net/problem/2606﻿
  
  알고리즘
    1. 그래프 이론
    2. 그래프 탐색
    3. 너비 우선 탐색
    4. 깊이 우선 탐색
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int node = Integer.parseInt(br.readLine());
        boolean computer[][] = new boolean[num+1][num+1];
        int col, row;
        while(node-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            col = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            computer[col][row] = true;
            computer[row][col] = true;
        }
        boolean visit[] = new boolean[num+1];
        visit[1] = true;
        virus(computer, visit, num, 1);
        int cnt=0;
        for(int i=2; i<=num; i++)
            if(visit[i])
                cnt++;
        System.out.println(cnt);
    }
    static void virus(boolean computer[][], boolean visit[], int num, int idx) {
        for(int i=1; i<=num; i++){
            if(computer[idx][i] && !visit[i]) {
                visit[i] = true;
                virus(computer, visit, num, i);
            }
        }
    }
}
