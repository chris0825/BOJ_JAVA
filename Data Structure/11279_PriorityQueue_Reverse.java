/**
  백준 11279번 - 최대 힙
  https://www.acmicpc.net/problem/11279
  
  알고리즘 분류
    1. 자료 구조
    2. 우선순위 큐
*/
import java.util.*;  
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        String command;
        while(n-- > 0) {
            command = br.readLine();
            if(command.equals("0"))
                bw.write((maxHeap.isEmpty() ? "0" : maxHeap.remove())+"\n");
            else
                maxHeap.add(Integer.parseInt(command));
        }
        bw.close();
    }
}
