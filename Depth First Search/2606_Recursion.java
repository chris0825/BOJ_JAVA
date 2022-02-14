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
    static int cnt=0, num;
    static boolean computer[][], visited[];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        int node = Integer.parseInt(br.readLine());
        computer = new boolean[num+1][num+1];
        int col, row;
        while(node-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            col = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            computer[col][row] = true;
            computer[row][col] = true;
        }
        visited = new boolean[num+1];
        visited[1] = true;
        virus(1);
        System.out.println(cnt);
    }
    static void virus(int idx) {
        for(int i=2; i<=num; i++)
            if(computer[idx][i] && !visited[i]) {
                visited[i] = true;
                cnt++;
                virus(i);
            }
    }
}
