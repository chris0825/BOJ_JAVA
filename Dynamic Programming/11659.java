/**
  백준 11659번 - 구간 합 구하기 4
  https://www.acmicpc.net/problem/11659
  
  알고리즘 분류
    1. 누적 합
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int numList[] = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++)
            numList[i] = numList[i-1] + Integer.parseInt(st.nextToken());
        int i, j;
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken()) - 1;
            j = Integer.parseInt(st.nextToken());
            bw.write(numList[j] - numList[i]+"\n");
        }
        bw.close();
    }
}
