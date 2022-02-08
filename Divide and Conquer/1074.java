/**
  백준 1074번 - Z
  https://www.acmicpc.net/problem/1074
  
  알고리즘 분류
    1. 분할 정복
    2. 재귀
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer init = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(init.nextToken());
        int c = Integer.parseInt(init.nextToken());
        int r = Integer.parseInt(init.nextToken());
        System.out.println(zSearch(c, r, n));
    }
    static int zSearch(int c, int r, int n) {
        int size = (int)Math.pow(2, n);
        int cMfy = 0, rMfy = 0;
        int ans = 0;
        while(size != 1) {
            if(c >= size/2+cMfy && r >= size/2+rMfy) { // 우하
                ans += size*size/4*3;
                rMfy += size/2;
                cMfy += size/2;
            }
            else if(c < size/2+cMfy && r >= size/2+rMfy) { // 우상
                ans += size*size/4;
                rMfy += size/2;
            }
            else if(c >= size/2+cMfy && r < size/2+rMfy) { // 좌하
                ans += size*size/2;
                cMfy += size/2;
            }
            size /= 2;
        }
        return ans;
    }
}
