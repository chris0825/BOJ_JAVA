/**
  백준 1697번 - 숨바꼭질
  https://www.acmicpc.net/problem/1697
  
  알고리즘 분류
    1. 그래프 이론
    2. 그래프 탐색
    3. 너비 우선 탐색
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int subin = Integer.parseInt(st.nextToken());
        int sister = Integer.parseInt(st.nextToken());
        System.out.println(hideAseek(subin, sister));
    }
    static int hideAseek(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int second[] = new int[100001];
        second[start] = 1;
        int temp;
        while(!queue.isEmpty()) {
            temp = queue.remove();
            if(temp-1 >= 0 && second[temp-1] == 0) {
                queue.add(temp-1);
                second[temp-1] = second[temp] + 1;
            }
            if(temp*2 <= 100000 && second[temp*2] == 0) {
                queue.add(temp*2);
                second[temp*2] = second[temp] + 1;
            }
            if(temp+1 <= 100000 && second[temp+1] == 0) {
                queue.add(temp+1);
                second[temp+1] = second[temp] + 1;
            }
            if(second[end] != 0)
                break;
        }
        return second[end]-1;
    }
}
