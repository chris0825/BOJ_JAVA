/**
  백준 1764번 - 듣보잡
  https://www.acmicpc.net/problem/1764﻿
  
  알고리즘 분류
    1. 자료 구조
    2. 문자열
    3. 정렬
    4. 해시를 이용한 집합과 맵
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nHeard = Integer.parseInt(st.nextToken());
        int nSee = Integer.parseInt(st.nextToken());
        HashSet<String> heard = new HashSet<>();
        ArrayList<String> strange = new ArrayList<>();
        while(nHeard-- > 0)
            heard.add(br.readLine());
        String name;
        while(nSee-- > 0) {
            name = br.readLine();
            if(heard.contains(name))
                strange.add(name);
        }
        Collections.sort(strange);
        bw.write(strange.size()+"\n");
        for(int i=0; i<strange.size(); i++)
            bw.write(strange.get(i)+"\n");
        bw.close();
    }
}
