/**
  백준 7569번 - 토마토
  https://www.acmicpc.net/problem/7569
  
  알고리즘 분류
    1. 그래프 이론
    2. 그래프 탐색
    3. 너비 우선 탐색
*/
import java.util.*;  
import java.io.*;  

public class Main {
    static int tomato[][][], rSize, cSize, floor;
    static Queue<Spot> queue = new LinkedList<>();
    public static void main(String args[]) throws IOException{  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringTokenizer size = new StringTokenizer(br.readLine());
        rSize = Integer.parseInt(size.nextToken());
        cSize = Integer.parseInt(size.nextToken());
        floor = Integer.parseInt(size.nextToken());
        tomato = new int[floor][cSize][rSize];
        for(int i=0; i<floor; i++)
            for(int j=0; j<cSize; j++) {  
                StringTokenizer st = new StringTokenizer(br.readLine());  
                for(int k=0; k<rSize; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    if(tomato[i][j][k] == 1)
                        queue.add(new Spot(i, j, k));
                }  
            }
        System.out.println(bfs()); 
    } 
    static class Spot { 
        int floor;
        int col; 
        int row; 
        Spot(int f, int c, int r) {
            this.floor = f;
            this.col = c;
            this.row = r; 
        } 
    }
    static int bfs() { 
        Spot s; 
        while(!queue.isEmpty()) {
            s = queue.remove(); 
            if(s.floor+1 < floor && tomato[s.floor+1][s.col][s.row] == 0) { 
                queue.add(new Spot(s.floor+1, s.col, s.row)); 
                tomato[s.floor+1][s.col][s.row] = tomato[s.floor][s.col][s.row]+1; 
            }
            if(s.col+1 < cSize && tomato[s.floor][s.col+1][s.row] == 0) { 
                queue.add(new Spot(s.floor, s.col+1, s.row)); 
                tomato[s.floor][s.col+1][s.row] = tomato[s.floor][s.col][s.row]+1; 
            } 
            if(s.row+1 < rSize && tomato[s.floor][s.col][s.row+1] == 0) { 
                queue.add(new Spot(s.floor, s.col, s.row+1)); 
                tomato[s.floor][s.col][s.row+1] = tomato[s.floor][s.col][s.row]+1;
            }
            if(s.floor-1 >= 0 && tomato[s.floor-1][s.col][s.row] == 0) { 
                queue.add(new Spot(s.floor-1, s.col, s.row)); 
                tomato[s.floor-1][s.col][s.row] = tomato[s.floor][s.col][s.row]+1; 
            }
            if(s.col-1 >= 0 && tomato[s.floor][s.col-1][s.row] == 0) { 
                queue.add(new Spot(s.floor, s.col-1, s.row)); 
                tomato[s.floor][s.col-1][s.row] = tomato[s.floor][s.col][s.row]+1;
            } 
            if(s.row-1 >= 0 && tomato[s.floor][s.col][s.row-1] == 0) { 
                queue.add(new Spot(s.floor, s.col, s.row-1)); 
                tomato[s.floor][s.col][s.row-1] = tomato[s.floor][s.col][s.row]+1;
            } 
        }
        return ripeDay();
    }
    static int ripeDay() {
        int d = 0;
        for(int i=0; i<floor; i++)
            for(int j=0; j<cSize; j++)
                for(int k=0; k<rSize; k++) {
                    d = Math.max(d, tomato[i][j][k]);
                    if(tomato[i][j][k] == 0)
                        return -1;
                }
        return d-1;
    }
}
