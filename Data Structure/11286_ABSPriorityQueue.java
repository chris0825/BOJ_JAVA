/**
  백준 11286번 - 절댓값 힙
  https://www.acmicpc.net/problem/11286
  
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
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) == Math.abs(o2))
                    return o1 > o2 ? 1 : -1;
                else
                    return Math.abs(o1) - Math.abs(o2);
            }
        });
        int command;
        while(n-- > 0) {
            command = Integer.parseInt(br.readLine());
            if(command == 0){
                if(pq.isEmpty())
                    bw.write("0\n");
                else
                    bw.write(pq.remove()+"\n");
            }
            else
                pq.add(command);
        }
        bw.close();
    }
}
