import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static boolean node[][], visited[];
    static Stack<Integer> stack = new Stack<>();
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer init = new StringTokenizer(br.readLine());
        n = Integer.parseInt(init.nextToken());
        int m = Integer.parseInt(init.nextToken());
        node = new boolean[n+1][n+1];
        int v1, v2;
        while(m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            node[v1][v2] = true;
            node[v2][v1] = true;
        }
        visited = new boolean[n+1];
        int cnt = 0;
        for(int i=1; i<=n; i++)
            if(!visited[i]) {
                cnt++;
                dfs(i);
            }
        System.out.println(cnt);
    }
    static void dfs(int sV) {
        stack.add(sV);
        visited[sV] = true;
        int vn;
        while(!stack.isEmpty()) {
            vn = stack.pop();
            for(int i=1; i<=n; i++)
                if(node[vn][i] && !visited[i]) {
                    stack.add(i);
                    visited[i] = true;
                }
        }
    }
}
