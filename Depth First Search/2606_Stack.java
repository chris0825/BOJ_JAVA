/**
  백준 2606번 - 바이러스(Stack+Loop Ver.)
  https://www.acmicpc.net/problem/2606
  
  알고리즘 분류
    1. 그래프 이론
    2. 그래프 탐색
    3. 너비 우선 탐색
    4. 깊이 우선 탐색
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int node = Integer.parseInt(br.readLine());
        boolean computer[][] = new boolean[num+1][num+1];
        int col, row;
        while(node-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            col = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            computer[col][row] = true;
            computer[row][col] = true;
        }
        System.out.println(dfs(computer, num));
    }
    static int dfs(boolean computer[][], int num) {
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[num+1];
        stack.add(1);
        visited[1] = true;
        int comN, cnt = 0;
        while(!stack.isEmpty()) {
            comN = stack.pop();
            for(int i=2; i<=num; i++)
                if(computer[comN][i] && !visited[i]) {
                    visited[i] = true;
                    cnt++;
                    stack.add(i);
                }
        }
        return cnt;
    }
}
