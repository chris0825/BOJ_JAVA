/**
  백준 2805번 - 나무 자르기
  https://www.acmicpc.net/problem/2805
  
  알고리즘
    1. 이분 탐색
    2. 매개 변수 탐색
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer init = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(init.nextToken());
        int m = Integer.parseInt(init.nextToken());
        int tree[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree);
        int max = tree[n-1];
        int min = 0;
        int mid = 0;
        long sum;
        while(min < max){
            mid = (max + min) / 2;
            sum = 0;
            for(int t : tree)
                if(t > mid)
                    sum += t - mid;
            if(sum < m)
                max = mid;
            else 
                min = mid + 1;
        }
        System.out.println(min - 1);
    }
}
