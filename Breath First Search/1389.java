/**
  백준 1389번 - 케빈 베이컨의 6단계 법칙
  https://www.acmicpc.net/problem/1389
  
  알고리즘 분류
    1. 그래프 이론
    2. 그래프 탐색
    3. 너비 우선 탐색
    4. 플로이드–와샬
*/
import java.util.*;
import java.io.*;

public class Main {
    static int user, minKB[] = {1, Integer.MAX_VALUE};
    static ArrayList<Integer> relation[];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        user = Integer.parseInt(st.nextToken());
        int rNum = Integer.parseInt(st.nextToken());
        relation = new ArrayList[user+1];
        for(int i=1; i<=user; i++)
            relation[i] = new ArrayList<>();
        int a, b;
        while(rNum-- > 0) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            relation[a].add(b);
            relation[b].add(a);
        }
        for(int i=1; i<=user; i++)
            bfs(i);
        System.out.println(minKB[0]);
    }
    static class KB {
        int v;
        int cnt;
        KB (int vertex, int count) {
            this.v = vertex;
            this.cnt = count;
        }
    }
    static void bfs(int sV) {
        Queue<KB> queue = new LinkedList<>();
        queue.add(new KB(sV, 0));
        boolean visited[] = new boolean[user+1];
        visited[sV] = true;
        int distance[] = new int[user+1];
        Arrays.fill(distance, 1000);
        distance[sV] = 0;
        KB v;
        while(!queue.isEmpty()) {
            v = queue.remove();
            for(int i : relation[v.v]) {
                if(!visited[i]) {
                    visited[i] = true;
                    distance[i] = v.cnt;
                    queue.add(new KB(i, v.cnt+1));
                }
            }
        }
        kevinBacon(sV, distance);
    }
    static void kevinBacon(int v, int distance[]){
        int kbNum = 0;
        for(int i=1; i<=user; i++)
            kbNum += distance[i];
        if(kbNum < minKB[1]) {
            minKB[0] = v;
            minKB[1] = kbNum;
        }
    }
}
