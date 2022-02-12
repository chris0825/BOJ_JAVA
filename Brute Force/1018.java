/**
  백준 1018번 - 체스판 다시 칠하기
  https://www.acmicpc.net/problem/1018
  
  알고리즘 분류
    1. 브루트포스 알고리즘
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        String board[] = new String[col];
        for(int i=0; i<col; i++)
            board[i] = br.readLine();
        int min = Integer.MAX_VALUE;
        int cnt1, cnt2;
        for(int i=0; i<col-7; i++)
            for(int j=0; j<row-7; j++){
                cnt1=0;
                cnt2=0;
                for(int p=i; p<i+8; p++)
                    for(int q=j; q<j+8; q++){
                        if(p % 2 == 0){
                            if(q % 2 == 0){
                                if(board[p].charAt(q) == 'W')
                                    cnt1++;
                                else
                                    cnt2++;
                            }
                            else{
                                if(board[p].charAt(q) == 'B')
                                    cnt1++;
                                else
                                    cnt2++;
                            }
                        }
                        else{
                            if(q % 2 == 0){
                                if(board[p].charAt(q) == 'B')
                                    cnt1++;
                                else
                                    cnt2++;
                            }
                            else{
                                if(board[p].charAt(q) == 'W')
                                    cnt1++;
                                else
                                    cnt2++;
                            }
                        }
                    }
                min = Math.min(min, Math.min(cnt1, cnt2));
            }
        System.out.println(min);
    }
}
