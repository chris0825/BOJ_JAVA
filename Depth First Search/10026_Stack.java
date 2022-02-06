/**
  백준 10026번 - 적록색약 (Recursion VER.)
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
                    stack.add(new Spot(i, j));
                    dfs(board[i][j], board);
                }
                if(!bBoard[i][j].equals("0")) {
                    bSector++;
                    stack.add(new Spot(i, j));
                    dfs(bBoard[i][j], bBoard);
                }
            }
        System.out.println(sector+" "+bSector);
    }
    static class Spot {
        int r;
        int c;
        Spot(int row, int col) {
            this.r = row;
            this.c = col;
        }
    }
    static Stack<Spot> stack = new Stack<>();
    static void dfs(String color, String board[][]) {
        Spot s;
        while(!stack.isEmpty()) {
            s = stack.pop();
            if(n > s.r+1 && board[s.r+1][s.c].equals(color)) {
                stack.add(new Spot(s.r+1, s.c));
                board[s.r+1][s.c] = "0";
            }
            if(0 <= s.r-1 && board[s.r-1][s.c].equals(color)) {
                stack.add(new Spot(s.r-1, s.c));
                board[s.r-1][s.c] = "0";
            }
            if(n > s.c+1 && board[s.r][s.c+1].equals(color)) {
                stack.add(new Spot(s.r, s.c+1));
                board[s.r][s.c+1] = "0";
            }
            if(0 <= s.c-1 && board[s.r][s.c-1].equals(color)) {
                stack.add(new Spot(s.r, s.c-1));
                board[s.r][s.c-1] = "0";
            }
        }
    }
}
