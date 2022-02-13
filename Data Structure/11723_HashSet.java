/**
  백준 11723번 - 집합 (HashSet VER.)
  https://www.acmicpc.net/problem/11723﻿
  
  알고리즘 분류
    1. 구현
    2. 비트마스킹
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());
        HashSet<Integer> aList = new HashSet<>();
        int x;
        while(m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken()) {
                case "add":
                    aList.add(Integer.parseInt(st.nextToken()));
                    break;
                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    if(aList.contains(x))
                        aList.remove(Integer.valueOf(x));
                    break;
                case "check":
                    x = Integer.parseInt(st.nextToken());
                    bw.write((aList.contains(x) ? "1" : "0")+"\n");
                    break;
                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    if(aList.contains(x))
                        aList.remove(Integer.valueOf(x));
                    else
                        aList.add(x);
                    break;
                case "all":
                    aList.clear();
                    for(int i=1; i<=20; i++)
                        aList.add(i);
                    break;
                case "empty":
                    aList.clear();
                    break;
            }
        }
        bw.close();
    }
}
