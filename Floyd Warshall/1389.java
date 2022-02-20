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
    static int user, relation[][];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer init = new StringTokenizer(br.readLine());
        user = Integer.parseInt(init.nextToken());
        int rNum = Integer.parseInt(init.nextToken());
        relation = new int[user+1][user+1];
        for(int i=0; i<=user; i++) {
            Arrays.fill(relation[i], 1000);
            relation[i][i] = 0;
        }
        int a, b;
        StringTokenizer st;
        while(rNum-- > 0) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            relation[a][b] = relation[b][a] = 1;
        }
        floyd_warshall();
        System.out.println(kevinBacon());
    }
    static void floyd_warshall() {
        for(int k=1; k<=user; k++)
            for(int i=1; i<=user; i++)
                for(int j=1; j<=user; j++)
                    relation[i][j] = Math.min(relation[i][j], relation[i][k] + relation[k][j]);
    }
    static int kevinBacon(){
        int minKevin[] = {1, Integer.MAX_VALUE};
        int kevinNum;
        for(int i=1; i<=user; i++) {
            kevinNum = 0;
            for(int j=1; j<=user; j++)
                kevinNum += relation[i][j];
            if(kevinNum < minKevin[1]) {
                minKevin[0] = i;
                minKevin[1] = kevinNum;
            }
        }
        return minKevin[0];
    }
}
