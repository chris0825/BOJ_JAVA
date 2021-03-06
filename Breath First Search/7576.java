/**
  백준 7576번 - 토마토
  https://www.acmicpc.net/problem/7576
  
  알고리즘 분류
    1. 그래프 이론
    2. 그래프 탐색
    3. 너비 우선 탐색
*/
import java.util.*;  
import java.io.*;  

public class Main {
    public static void main(String args[]) throws IOException{  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringTokenizer size = new StringTokenizer(br.readLine());  
        int rSize = Integer.parseInt(size.nextToken());
        int cSize = Integer.parseInt(size.nextToken());
        int tomato[][] = new int[cSize][rSize];
        Queue<Spot> queue = new LinkedList<>();
        for(int i=0; i<cSize; i++) {  
            StringTokenizer st = new StringTokenizer(br.readLine());  
            for(int j=0; j<rSize; j++) {  
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if(tomato[i][j] == 1)  
                    queue.add(new Spot(i, j));
            }  
        } 
        bfs(tomato, queue, cSize, rSize);
        System.out.println(ripeDay(tomato, cSize, rSize)); 
    } 
    static class Spot { 
        int col; 
        int row; 
        Spot(int c, int r) {
            this.col = c; 
            this.row = r; 
        } 
    }
    static int ripeDay(int tomato[][], int cSize, int rSize) {
        int d = 0;
        for(int i=0; i<cSize; i++)
            for(int j=0; j<rSize; j++) {
                d = Math.max(d, tomato[i][j]);
                if(tomato[i][j] == 0)
                    return -1;
            }
        return d-1;
    }
    static void bfs(int tomato[][], Queue<Spot> queue, int cSize, int rSize) { 
        Spot s; 
        while(!queue.isEmpty()) {
            s = queue.remove(); 
            if(s.col+1 < cSize && tomato[s.col+1][s.row] == 0) { 
                queue.add(new Spot(s.col+1, s.row)); 
                tomato[s.col+1][s.row] = tomato[s.col][s.row]+1; 
            } 
            if(s.row+1 < rSize && tomato[s.col][s.row+1] == 0) { 
                queue.add(new Spot(s.col, s.row+1)); 
                tomato[s.col][s.row+1] = tomato[s.col][s.row]+1;
            } 
            if(s.col-1 >= 0 && tomato[s.col-1][s.row] == 0) { 
                queue.add(new Spot(s.col-1, s.row)); 
                tomato[s.col-1][s.row] = tomato[s.col][s.row]+1;
            } 
            if(s.row-1 >= 0 && tomato[s.col][s.row-1] == 0) { 
                queue.add(new Spot(s.col, s.row-1)); 
                tomato[s.col][s.row-1] = tomato[s.col][s.row]+1;
            } 
        } 
    } 
}
