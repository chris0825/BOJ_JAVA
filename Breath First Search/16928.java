/**
  백준 16928번 - 뱀과 사다리 게임
  https://www.acmicpc.net/problem/16928
  
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
        StringTokenizer init = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(init.nextToken());
        int m = Integer.parseInt(init.nextToken());
        HashMap<Integer, Integer> snl = new HashMap<>();
        for(int i=0; i<n+m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            snl.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        System.out.println(bfs(snl));
    }
    static int bfs(HashMap<Integer, Integer> snl) {
        Queue<Integer> queue = new LinkedList<>();
        int cnt[] = new int[101];
        queue.add(1);
        cnt[1] = 1;
        int idx;
        while(!queue.isEmpty()) {
            idx = queue.remove();
            if(idx == 100)
                return cnt[100]-1;
            for(int i=1; i<=6 && idx+i<=100; i++) {
                if(cnt[idx+i] != 0)
                    continue;
                cnt[idx+i] = cnt[idx]+1;
                if(snl.containsKey(idx+i)) {
                    if(cnt[snl.get(idx+i)] != 0)
                        continue;
                    queue.add(snl.get(idx+i));
                    cnt[snl.get(idx+i)] = cnt[idx]+1;
                }
                else
                    queue.add(idx+i);
            }
                    
        }
        return Integer.MAX_VALUE;
    }
}
