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
        int r = Integer.parseInt(init.nextToken());
        int c = Integer.parseInt(init.nextToken());
        System.out.println(zSearch(r, c, (int)Math.pow(2, n)));
    }
    static int zSearch(int r, int c, int size) {
        int rMfy = 0, cMfy = 0, ans = 0;
        while(size != 1) {
            if(r >= size/2+rMfy && c >= size/2+cMfy) { // 우하
                ans += size*size/4*3;
                cMfy += size/2;
                rMfy += size/2;
            }
            else if(r < size/2+rMfy && c >= size/2+cMfy) { // 우상
                ans += size*size/4;
                cMfy += size/2;
            }
            else if(r >= size/2+rMfy && c < size/2+cMfy) { // 좌하
                ans += size*size/2;
                rMfy += size/2;
            }
            size /= 2;
        }
        return ans;
    }
}
