/**
  백준 10026번 - 적록색약 (Recursion VER.)
  https://www.acmicpc.net/problem/10026﻿
  
  알고리즘 분류
    1. 그래프 이론
    2. 그래프 탐색
    3. 너비 우선 탐색
    4. 깊이 우선 
*/
import java.io.*;

public class Main {
    static int n;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String board[][] = new String[n][n];
        String bBoard[][] = new String[n][n];
        for(int i=0; i<n; i++) {
            board[i] = br.readLine().split("");
            for(int j=0; j<n; j++)
                if(board[i][j].equals("R"))
                    bBoard[i][j] = "G";
                else
                    bBoard[i][j] = board[i][j];
        }
        int sector = 0, bSector = 0;
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++){
                if(!board[i][j].equals("0")) {
                    sector++;
                    isSector(i, j, board[i][j], board);
                }
                if(!bBoard[i][j].equals("0")) {
                    bSector++;
                    isSector(i, j, bBoard[i][j], bBoard);
                }
            }
        System.out.println(sector+" "+bSector);
    }
    static void isSector(int i, int j, String color, String board[][]) {
        if(board[i][j].equals(color)) {
            board[i][j] = "0";
            if(n > i+1)
                isSector(i+1, j, color, board);
            if(0 <= i-1)
                isSector(i-1, j, color, board);
            if(n > j+1)
                isSector(i, j+1, color, board);
            if(0 <= j-1)
                isSector(i, j-1, color, board);
        }
    }
}
