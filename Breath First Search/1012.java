/**
  백준 1012번 - 유기농 배추
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
    static int field[][], cSize, rSize, locNum, mR[] = {-1, 0, 1, 0}, mC[] = {0, -1, 0, 1};
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tC = Integer.parseInt(br.readLine());
        while(tC-- > 0) {
            StringTokenizer init = new StringTokenizer(br.readLine());
            rSize = Integer.parseInt(init.nextToken());
            cSize = Integer.parseInt(init.nextToken());
            field = new int[rSize][cSize];
            locNum = Integer.parseInt(init.nextToken());
            while(locNum-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                field[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }
            int num = 0;
            for(int i=0; i<rSize; i++)
                for(int j=0; j<cSize; j++)
                    if(field[i][j] == 1) {
                        bfs(i, j);
                        num++;
                    }
            bw.write(num+"\n");
        }
        bw.close();
    }
    static class Spot {
        int r;
        int c;
        Spot(int row, int col) {
            this.r = row;
            this.c = col;
        }
    }
    static void bfs(int row, int col) {
        Queue<Spot> queue = new LinkedList<>();
        queue.add(new Spot(row, col));
        field[row][col] = 0;
        Spot s;
        int newR, newC;
        while(!queue.isEmpty()) {
            s = queue.remove();
            for(int i=0; i<4; i++) {
                newR = s.r+mR[i];
                newC = s.c+mC[i];
                if(isArea(newR, newC) && field[newR][newC] == 1) {
                    field[newR][newC] = 0;
                    queue.add(new Spot(newR, newC));
                }
            }
        }
    }
    static boolean isArea(int r, int c) {
        return r>=0 && r<rSize && c>=0 && c<cSize;
    }
}
