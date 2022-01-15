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
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer init = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(init.nextToken());
        int m = Integer.parseInt(init.nextToken());
        int v = Integer.parseInt(init.nextToken());
        boolean node[][] = new boolean[n+1][n+1];
        boolean visit[] = new boolean[n+1];
        int n1, n2;
        while(m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());
            node[n1][n2] = true;
            node[n2][n1] = true;
        }
        dfs(v, node, visit);
        bw.newLine();
        for(int i=0; i<node.length; i++)
            visit[i] = false;
        bw.write(bfs(v, node, visit));
        bw.close();
    }
    static String bfs(int v, boolean node[][], boolean visit[]) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visit[v] = true;
        while(!queue.isEmpty()) {
            int idx = queue.remove();
            sb.append(idx+" ");
            for(int i=1; i<node.length; i++) 
                if(node[idx][i] && !visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                }
        }
        return String.valueOf(sb);
    }
    static void dfs(int v, boolean node[][], boolean visit[]) {
        visit[v] = true;
        System.out.print(v+" ");
        for(int i=1; i<node.length; i++)
            if(node[v][i] && !visit[i])
                dfs(i, node, visit);
    }
}
