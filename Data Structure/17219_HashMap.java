/**
  백준 17219번 - 비밀번호 찾기
  https://www.acmicpc.net/problem/17219
  
  알고리즘 분류
    1. 자료 구조
    2. 해시를 사용한 집합과 맵
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, String> sitePW = new HashMap();
        StringTokenizer info;
        for(int i=0; i<n; i++) {
            info = new StringTokenizer(br.readLine());
            sitePW.put(info.nextToken(), info.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++)
            sb.append(sitePW.get(br.readLine())+"\n");
        bw.write(sb.toString());
        bw.close();
    }
}
