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
    static int cSize, rSize, visited[][];
    static String maze[][];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer size = new StringTokenizer(br.readLine());
        cSize = Integer.parseInt(size.nextToken());
        rSize = Integer.parseInt(size.nextToken());
        maze = new String[cSize][rSize];
        visited = new int[cSize][rSize];
        for(int i=0; i<cSize; i++)
            maze[i] = br.readLine().split("");
        bfs(0, 0);
        bw.write(String.valueOf(visited[cSize-1][rSize-1]));
        bw.close();
    }
    static class Spot{
        int x;
        int y;
        
        Spot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static void bfs(int col, int row) {
        Queue<Spot> queue = new LinkedList<>();
        queue.add(new Spot(col, row));
        visited[col][row] = 1;
        while(!queue.isEmpty()) {
            Spot s = queue.remove();
            if(s.x+1 < cSize && visited[s.x+1][s.y]==0 && maze[s.x+1][s.y].equals("1")) {
                queue.add(new Spot(s.x+1, s.y));
                visited[s.x+1][s.y] = visited[s.x][s.y] + 1;
            }
            if(s.y+1 < rSize && visited[s.x][s.y+1]==0 && maze[s.x][s.y+1].equals("1")) {
                queue.add(new Spot(s.x, s.y+1));
                visited[s.x][s.y+1] = visited[s.x][s.y] + 1;
            }
            if(s.x-1 >= 0 && visited[s.x-1][s.y]==0 && maze[s.x-1][s.y].equals("1")) {
                queue.add(new Spot(s.x-1, s.y));;
                visited[s.x-1][s.y] = visited[s.x][s.y] + 1;
            }
            if(s.y-1 >= 0 && visited[s.x][s.y-1]==0 && maze[s.x][s.y-1].equals("1")) {
                queue.add(new Spot(s.x, s.y-1));
                visited[s.x][s.y-1] = visited[s.x][s.y] + 1;
            }
        }
    }
}
