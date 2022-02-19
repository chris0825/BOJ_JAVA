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
        PriorityQueue<Integer> negHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> posHeap = new PriorityQueue<>();
        String command;
        while(n-- > 0) {
            command = br.readLine();
            if(command.equals("0")){
                if(negHeap.isEmpty() && posHeap.isEmpty())
                    bw.write("0\n");
                else if(negHeap.isEmpty())
                    bw.write(posHeap.remove()+"\n");
                else if(posHeap.isEmpty())
                    bw.write(negHeap.remove()+"\n");
                else if(negHeap.peek()*-1 == posHeap.peek())
                    bw.write(negHeap.remove()+"\n");
                else if(negHeap.peek()*-1 > posHeap.peek())
                    bw.write(posHeap.remove()+"\n");
                else
                    bw.write(negHeap.remove()+"\n");
            }
            else {
                if(Integer.parseInt(command) < 0)
                    negHeap.add(Integer.parseInt(command));
                else
                    posHeap.add(Integer.parseInt(command));
            }
        }
        bw.close();
    }
}
