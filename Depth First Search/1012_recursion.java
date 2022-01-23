/**
  백준 1012번 - 유기농 배추(Recursion Ver.)
  https://www.acmicpc.net/problem/1012
  
  알고리즘 분류
    1. 그래프 이론
    2. 그래프 탐색
    3. 너비 우선 탐색
    4. 깊이 우선 탐색
*/
import java.util.*;
import java.io.*;

public class Main {
    static int field[][], cSize, rSize;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tC = Integer.parseInt(br.readLine());
        while(tC-- > 0) {
            StringTokenizer init = new StringTokenizer(br.readLine());
            cSize = Integer.parseInt(init.nextToken());
            rSize = Integer.parseInt(init.nextToken());
            field = new int[cSize][rSize];
            int locNum = Integer.parseInt(init.nextToken());
            while(locNum-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                field[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }
            int num = 0;
            for(int i=0; i<cSize; i++)
                for(int j=0; j<rSize; j++)
                    if(field[i][j] == 1) {
                        num++;
                        cabbage(i, j);
                    }
            bw.write(num+"\n");
        }
        bw.close();
    }
    static void cabbage(int i, int j) {
        if(field[i][j] == 1) {
            field[i][j] = 0;
            if(i+1 < cSize)
                cabbage(i+1, j);
            if(j+1 < rSize)
                cabbage(i, j+1);
            if(i-1 >= 0)
                cabbage(i-1, j);
            if(j-1 >= 0)
                cabbage(i, j-1);
        }
    }
}
