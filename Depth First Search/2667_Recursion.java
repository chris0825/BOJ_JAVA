/**
  백준 2667번 - 단지번호붙이기 (재귀 Ver.)
  https://www.acmicpc.net/problem/2667
  
  알고리즘
    1. 그래프 이론
    2. 그래프 탐색
    3. 너비 우선 탐색
    4. 깊이 우선 탐색
*/
import java.util.*;
import java.io.*;

public class Main {
    static int size = 0;
    static String apart[][] = new String[25][25];
    static int num = 0;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        size = Integer.parseInt(br.readLine());
        for(int i=0; i<size; i++)
            apart[i] = br.readLine().split("");
        int cnt = 0;
        ArrayList<Integer> numList = new ArrayList<>();;
        for(int i=0; i<size; i++)
            for(int j=0; j<size; j++)
                if(apart[i][j].equals("1")) {
                    num = 0;
                    connected(i, j);
                    numList.add(num);
                    cnt++;
                }
        bw.write(cnt+"\n");
        Collections.sort(numList);
        for(int i=0; i<numList.size(); i++)
            bw.write(numList.get(i)+"\n");
        bw.close();
    }
    static void connected(int idxC, int idxR) {
        if(apart[idxC][idxR].equals("1")) {
            num++;
            apart[idxC][idxR] = "0";
            if(size > idxC+1)
                connected(idxC+1, idxR);
            if(0 <= idxC-1)
                connected(idxC-1, idxR);
            if(size > idxR+1)
                connected(idxC, idxR+1);
            if(0 <= idxR-1)
                connected(idxC, idxR-1);
        }
    }
}
