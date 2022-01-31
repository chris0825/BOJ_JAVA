/**
  백준 11724번 - 연결 요소의 개수 (Recursion Ver.)
  https://www.acmicpc.net/problem/11724
  
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
        StringTokenizer init = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(init.nextToken());
        int m = Integer.parseInt(init.nextToken());
        boolean node[][] = new boolean[n+1][n+1];
        int u, v;
        while(m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            node[u][v] = true;
            node[v][u] = true;
        }
        boolean visit[] = new boolean[n+1];
        int cnt = 0;
        for(int i=1; i<=n; i++)
            if(!visit[i]) {
                cnt++;
                connected(node, visit, i, n);
            }
        System.out.println(cnt);
    }
    static void connected(boolean node[][], boolean visit[], int idx, int num) {
        for(int i=1; i<=num; i++){
            if(node[idx][i] && !visit[i]) {
                visit[i] = true;
                connected(node, visit, i, num);
            }
        }
    }
}
