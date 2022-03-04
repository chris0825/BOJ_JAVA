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
        int size = Integer.parseInt(br.readLine());
        int time[] = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<size; i++)
            time[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(time);
        int sum = 0;
        for(int i=0; i<size; i++)
            sum += time[i]*(size-i);
        System.out.println(sum);
    }
}
