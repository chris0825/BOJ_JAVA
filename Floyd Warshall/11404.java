/**
  백준 11404번 - 플로이드
  https://www.acmicpc.net/problem/11404
  
  알고리즘
    1. 그래프 이론
    2. 플로이드–와샬
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int routeN = Integer.parseInt(br.readLine());
        int route[][] = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            Arrays.fill(route[i], 1073741823); // Integer.MAX_VALUE/2 값으로 버스 노선이 없다고 가정(Integer.MAX_VALUE에 +1이라도 하면 오버플로우가 나서 음수값으로 변하기 때문)
            route[i][i] = 0; // 시작점과 도착점이 같은곳
        }
        int vi, vj;
        while(routeN-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            vi = Integer.parseInt(st.nextToken()); // 출발 도시
            vj = Integer.parseInt(st.nextToken()); // 도착 도시
            route[vi][vj] = Math.min(route[vi][vj], Integer.paseInt(st.nextToken())); // 이전 노선과 비교하여 더 비용이 작은 노선 선택
        }
        floyd_warshall(route); // 플로이드 와샬 알고리즘
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++)
                bw.write(route[i][j] == 1073741823 ? "0 " : route[i][j]+" "); // 노선이 없는 경우 0을 출력하고 그렇지 않은 경우 버스 이용 비용 출력
            bw.newLine();
        }
        bw.close();
    }
    // 플로이드 와샬 알고리즘
    static void floyd_warshall(int route[][]) {
        for (int k=1; k<route.length; k++)
            for (int i=1; i<route.length; i++)
                for (int j=1; j<route.length; j++)
                    route[i][j] = Math.min(route[i][j], route[i][k] + route[k][j]);
    }
}
