/**
  백준 1546번 - 평균
  https://www.acmicpc.net/problem/1546
  
  알고리즘 분류
    1. 수학
    2. 사칙연산
*/
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        double score[] = new double[num], max = 0, tot = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<num; i++)
            max = Math.max(max, score[i] = Integer.parseInt(st.nextToken()));
        for(int i=0; i<num; i++)
            tot += score[i]/max*100;
        System.out.println(tot/num);
    }
}
