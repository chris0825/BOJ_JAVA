/**
  백준 11399번 - ATM
  https://www.acmicpc.net/problem/11399
  
  알고리즘 분류
    1. 그리디 알고리즘
    2. 정렬
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int time[] = new int[n];
        for(int i=0; i<n; i++)
            time[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(time);
        int sum = 0;
        for(int i=0; i<n; i++)
            for(int j=0; j<=i; j++)
                sum += time[j];
        System.out.println(sum);
    }
}
