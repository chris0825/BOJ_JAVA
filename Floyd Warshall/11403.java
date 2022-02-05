/**
  백준 11403번 - 경로 찾기
  https://www.acmicpc.net/problem/11403
  
  알고리즘 분류
    1. 그래프 이론
    2. 그래프 탐색
    3. 플로이드-와샬
*/
import java.util.*;
import java.io.*;

public class Main {
    static int graph[][];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        graph = new int[num][num];
        int temp;
        for(int i=0; i<num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<num; j++)
                graph[i][j] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<num; i++)
            for(int j=0; j<num; j++)
                for(int k=0; k<num; k++)
                    if(graph[j][k]==1 || (graph[j][i]==1  && graph[i][k]==1))
						graph[j][k] = 1;
		for(int i=0; i<num; i++) {
		    for(int j=0; j<num; j++)
		        bw.write(graph[i][j]+" ");
		    bw.newLine();
		}
		bw.close();
    }
}
