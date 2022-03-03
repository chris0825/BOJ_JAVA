/**
  백준 11047번 - 동전 0
  https://www.acmicpc.net/problem/11047
  
  알고리즘 분류
    1. 그리디 알고리즘
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int coin[] = new int[n];
        while(n-- > 0)
            coin[n] = Integer.parseInt(br.readLine());
        int cnt = 0, i = 0;
        while (k != 0) {
            if(k < coin[i])
                i++;
            else {
                cnt += k / coin[i];
                k -= (k / coin[i]) * coin[i];
            }
        }
        System.out.println(cnt);
    }
}
