/**
  백준 1920번 - 수 찾기
  https://www.acmicpc.net/problem/1920
  
  알고리즘 분류
    1. 자료 구조
    2. 이분 탐색
    3. 트리를 사용한 집합과 맵
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        HashSet<String> list = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(len-- > 0)
            list.add(st.nextToken());
        len = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(len-- > 0)
            sb.append((list.contains(st.nextToken())? 1 : 0) + "\n");
        System.out.println(sb);
    }
}
