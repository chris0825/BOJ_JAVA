/**
  백준 1927번 - 최소 힙
  https://www.acmicpc.net/problem/1927
  
  알고리즘 분류
    1. 자료 구조
    2. 우선순위 
*/
import java.util.*;  
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        String command;
        while(n-- > 0) {
            command = br.readLine();
            if(command.equals("0"))
                bw.write((minHeap.isEmpty() ? "0" : minHeap.remove())+"\n");
            else
                minHeap.add(Integer.parseInt(command));
        }
        bw.close();
    }
}
