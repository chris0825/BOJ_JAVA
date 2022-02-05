/**
  백준 10026번 - 적록색약
  https://www.acmicpc.net/problem/10026﻿
  
  알고리즘 분류
    1. 그래프 이론
    2. 그래프 탐색
    3. 너비 우선 탐색
    4. 깊이 우선 
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String board[][] = new String[n][n];
        String bBoard[][] = new String[n][n];
        for(int i=0; i<n; i++) {
            board[i] = br.readLine().split("");
            bBoard[i] = board[i].clone();
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(bBoard[i][j].equals("R"))
                    bBoard[i][j] = "G";
            }
        }
        int sector = 0, bSector = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!board[i][j].equals("0")) {
                    sector++;
                    isSector(i, j, n, board[i][j], board);
                }
                if(!bBoard[i][j].equals("0")) {
                    bSector++;
                    isSector(i, j, n, bBoard[i][j], bBoard);
                }
            }
        }
        System.out.println(sector+" "+bSector);
    }
    static void isSector(int i, int j, int n, String color, String board[][]) {
        if(board[i][j].equals(color)) {
            board[i][j] = "0";
            if(n > i+1)
                isSector(i+1, j, n, color, board);
            if(0 <= i-1)
                isSector(i-1, j, n, color, board);
            if(n > j+1)
                isSector(i, j+1, n, color, board);
            if(0 <= j-1)
                isSector(i, j-1, n, color, board);
        }
    }
}
