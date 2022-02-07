/**
  백준 14500번 - 테트로미노
  https://www.acmicpc.net/problem/14500﻿
  
  알고리즘 분류
    1. 구현
    2. 브루트포스 알고리즘
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer init = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(init.nextToken());
        int row = Integer.parseInt(init.nextToken());
        int board[][] = new int[col][row];
        for(int i=0; i<col; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<row; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        for(int i=0; i<col; i++)
            for(int j=0; j<row; j++) {
                if(i+1 < col && j+1 < row)
                    ans = Math.max(ans, board[i][j]+board[i+1][j]+board[i][j+1]+board[i+1][j+1]); // ㅁ
                if(i+2 < col && j+1 < row) {
                    ans = Math.max(ans, board[i][j]+board[i+1][j]+board[i+1][j+1]+board[i+2][j]); //ㅏ
                    ans = Math.max(ans, board[i][j]+board[i+1][j]+board[i+1][j+1]+board[i+2][j+1]); // |_|
                    ans = Math.max(ans, board[i][j]+board[i+1][j]+board[i+2][j]+board[i+2][j+1]); // |_
                    ans = Math.max(ans, board[i][j]+board[i][j+1]+board[i+1][j+1]+board[i+2][j+1]); // -|
                }
                if(i+1 < col && j+2 < row) {
                    ans = Math.max(ans, board[i][j]+board[i][j+1]+board[i+1][j+1]+board[i][j+2]); // ㅜ
                    ans = Math.max(ans, board[i][j]+board[i][j+1]+board[i+1][j+1]+board[i+1][j+2]); // -|_
                    ans = Math.max(ans, board[i][j]+board[i+1][j]+board[i+1][j+1]+board[i+1][j+2]); // |__
                    ans = Math.max(ans, board[i][j]+board[i][j+1]+board[i][j+2]+board[i+1][j+2]); // --|
                }
                if(i-1 >= 0 && i+1 < col && j+1 < row)
                    ans = Math.max(ans, board[i][j]+board[i][j+1]+board[i-1][j+1]+board[i+1][j+1]); //ㅓ
                if(i-1 >= 0 && j+2 < row) {
                    ans = Math.max(ans, board[i][j]+board[i][j+1]+board[i-1][j+1]+board[i][j+2]); //ㅗ
                    ans = Math.max(ans, board[i][j]+board[i-1][j]+board[i-1][j+1]+board[i-1][j+2]); //|-
                    ans = Math.max(ans, board[i][j]+board[i][j+1]+board[i][j+2]+board[i-1][j+2]); //_|
                    ans = Math.max(ans, board[i][j]+board[i][j+1]+board[i-1][j+1]+board[i-1][j+2]); //_|-
                }
                if(i-2 >= 0 && j+1 < row) {
                    ans = Math.max(ans, board[i][j]+board[i][j+1]+board[i-1][j+1]+board[i-2][j+1]); //_|
                    ans = Math.max(ans, board[i][j]+board[i-1][j]+board[i-2][j]+board[i-2][j+1]); //|-
                    ans = Math.max(ans, board[i][j]+board[i-1][j]+board[i-1][j+1]+board[i-2][j+1]); // |-|
                }
                if(i+3 < col)
                    ans = Math.max(ans, board[i][j]+board[i+1][j]+board[i+2][j]+board[i+3][j]); // |
                if(j+3 < row)
                    ans = Math.max(ans, board[i][j]+board[i][j+1]+board[i][j+2]+board[i][j+3]); // ㅡ
                    
            }
        System.out.println(ans);
    }
}
