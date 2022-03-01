/**
  백준 10845번 - 큐
  https://www.acmicpc.net/problem/10845
  
  알고리즘 분류
    1. 자료 구조
    2. 큐
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        int remoteNum = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int rear = -1;
        StringBuilder sb = new StringBuilder();
        while(remoteNum-- > 0){
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "push":
                    queue.add(rear = Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append((queue.isEmpty() ? -1 : queue.remove())+"\n");
                    break;
                case "size":
                    sb.append(queue.size()+"\n");
                    break;
                case "empty":
                    sb.append((queue.isEmpty() ? 1 : 0)+"\n");
                    break;
                case "front":
                    sb.append((queue.isEmpty() ? -1 : queue.peek())+"\n");
                    break;
                case "back":
                    sb.append((queue.isEmpty() ? -1 : rear)+"\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
