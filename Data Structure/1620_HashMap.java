/**
  백준 1620번 - 나는야 포켓몬 마스터 이다솜
  https://www.acmicpc.net/problem/1620
  
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
        int num = Integer.parseInt(st.nextToken());
        int question = Integer.parseInt(st.nextToken());
        HashMap<String, String> poketmon = new HashMap<>();
        int idx = 0;
        while(num-- > 0) {
            poketmon.put(String.valueOf(++idx), br.readLine());
            poketmon.put(poketmon.get(String.valueOf(idx)), String.valueOf(idx));
        }
        while(question-- > 0)
            bw.write(poketmon.get(br.readLine())+"\n");
        bw.close();
    }
}
