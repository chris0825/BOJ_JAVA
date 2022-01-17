/**
  백준 2178번 - 미로 탐색
  https://www.acmicpc.net/problem/2178
  
  알고리즘
    1. 그래프 이론
    2. 그래프 탐색
    3. 너비 우선 탐색
*/
import java.util.*;
import java.io.*;

public class Main {
    static int cSize, rSize;
    static String maze[][];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer size = new StringTokenizer(br.readLine());
        cSize = Integer.parseInt(size.nextToken());
        rSize = Integer.parseInt(size.nextToken());
        maze = new String[cSize][rSize];
        for(int i=0; i<cSize; i++)
            maze[i] = br.readLine().split("");
        bw.write(bfs(0, 0)+"\n");
        bw.close();
    }
    static class Spot{
        int r;
        int c;
        Spot(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int bfs(int col, int row) {
        Queue<Spot> queue = new LinkedList<>();
        int visited[][] = new int[cSize][rSize];
        queue.add(new Spot(col, row));
        visited[col][row] = 1;
        int mR[] = {1, 0, -1, 0};
        int mC[] = {0, 1, 0, -1};
        while(!queue.isEmpty()) {
            Spot s = queue.remove();
            for(int i=0; i<4; i++)
                if(isArea(s.r+mR[i], s.c+mC[i]) && visited[s.r+mR[i]][s.c+mC[i]]==0 && maze[s.r+mR[i]][s.c+mC[i]].equals("1")) {
                    queue.add(new Spot(s.r+mR[i], s.c+mC[i]));
                    visited[s.r+mR[i]][s.c+mC[i]] = visited[s.r][s.c] + 1;
                }
        }
        return visited[cSize-1][rSize-1];
    }
    static boolean isArea(int col, int row) {
        return col >= 0 && col < cSize && row >= 0 && row < rSize;
    }
}
