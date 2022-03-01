/**
  백준 1780번 - 종이의 개수
  https://www.acmicpc.net/problem/1780
  
  알고리즘 분류
    1. 분할 정복
    2. 재귀
*/
import java.util.*;
import java.io.*;

public class Main {
    static int paper[][], cnt[] = new int[3];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        paper = new int[size][size];
        StringTokenizer st;
        for(int i=0; i<size; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++)
                paper[i][j] = Integer.parseInt(st.nextToken());
        }
        cutting(0, 0, size);
        for(int i=0; i<3; i++)
            System.out.println(cnt[i]);
    }
    static void cutting(int row, int col, int unit) {
        if(unit > 1) {
            if(!isEqual(row, col, unit)) {
                for(int i=row; i<row+unit; i+=unit/3)
                    for(int j=col; j<col+unit; j+=unit/3)
                        cutting(i, j, unit/3);
            }
            else
                cnt[paper[row][col]+1]++;
        }
        else
            cnt[paper[row][col]+1]++;
    }
    static boolean isEqual(int row, int col, int unit) {
        for(int i=row; i<row+unit; i++)
            for(int j=col; j<col+unit; j++)
                if(paper[row][col] != paper[i][j])
                    return false;
        return true;
    }
}
