/**
  백준 9375번 - 패션왕 신해빈
  https://www.acmicpc.net/problem/9375
  
  알고리즘 분류
    1. 
    2. 자료 구조
    3. 해시를 사용한 집합과 맵
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tC = Integer.parseInt(br.readLine());
        int cNum, cases;
        String cloth[] = new String[2];
        while(tC-- > 0) {
            HashMap<String, Integer> coordi = new HashMap<>();
            cNum = Integer.parseInt(br.readLine());
            cases = 1;
            while(cNum-- > 0) {
                cloth = br.readLine().split(" ");
                if(coordi.containsKey(cloth[1]))
                    coordi.put(cloth[1], coordi.get(cloth[1])+1);
                else
                    coordi.put(cloth[1], 2);
            }
            for(String key : coordi.keySet())
                cases *= coordi.get(key);
            bw.write((cases-1)+"\n");
        }
        bw.close();
    }
}
