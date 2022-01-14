/**
  백준 10989번 - 수 정렬하기 3
  https://www.acmicpc.net/problem/10989
  
  알고리즘
    1. 정렬
*/
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      int num = Integer.parseInt(bf.readLine());
      int list[] = new int[10001];
      for(int i=0; i<num; i++)
          list[Integer.parseInt(bf.readLine())]++;
      for(int i=1; i<10001; i++)
          for(int j=0; j<list[i]; j++)
              bw.write(i+"\n");
      bw.close();
    }
}
