/**
  백준 18870번 - 좌표 압축
  https://www.acmicpc.net/problem/18870
  
  알고리즘 분류
    1. 정렬
    2. 값 / 좌표 압축
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numList[] = new int[n];
        for(int i=0; i<n; i++)
            numList[i] = Integer.parseInt(st.nextToken());
        int sortList[] = numList.clone();
        Arrays.sort(sortList);
        HashMap<Integer, Integer> rankList = new HashMap<>();
        int rank = 0;
        for(int num : sortList)
            if(!rankList.containsKey(num))
                rankList.put(num, rank++);
        StringBuilder sb = new StringBuilder();
        for(int i : numList)
            sb.append(rankList.get(i)+" ");
        System.out.println(sb);
    }
}
