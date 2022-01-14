/**
  백준 1654번 - 랜선 자르기
  https://www.acmicpc.net/problem/1654
  
  알고리즘
    1. 이분 탐색
    2. 매개 변수 탐색
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long line[] = new long[k];
        long max = 0;
        for(int i=0; i<k; i++) {
            line[i] = Integer.parseInt(br.readLine());
            max = Math.max(line[i], max);
        }
        max++;
        long min = 0, mid=0, cnt;
        while(min < max){
            mid = (max+min) / 2;
            cnt = 0;
            for(int i=0; i<k; i++)
                cnt += line[i] / mid;
            if(cnt < n)
                max = mid;
            else
                min = mid+1;
        }
        System.out.print(min-1);
    }
}
