/**
  백준 1260번 - DFS와 BFS
  https://www.acmicpc.net/problem/1260
  
  알고리즘
    1. 그래프 이론
    2. 그래프 탐색
    3. 너비 우선 탐색
    4. 깊이 우선 탐색
*/
import java.util.*;
import java.io.*;

public class Main {
    static int n;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer init = new StringTokenizer(br.readLine());
        n = Integer.parseInt(init.nextToken());
        int m = Integer.parseInt(init.nextToken());
        int sV = Integer.parseInt(init.nextToken());
        boolean node[][] = new boolean[n+1][n+1];
        int v1, v2;
        while(m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            node[v1][v2] = true;
            node[v2][v1] = true;
        }
        bw.write(dfs(sV, node)+"\n");
        bw.close();
    }
    static String dfs(int v, boolean node[][]) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[n+1];
        stack.add(v);
        int idx;
        while(!stack.isEmpty()) {
            idx = stack.pop();
            if(visited[idx])
                continue;
            visited[idx] = true;
            sb.append(idx+" ");
            for(int i=n; i>0; i--)
                if(node[idx][i] && !visited[i])
                    stack.add(i);
        }
        return sb.toString();
    }
}
