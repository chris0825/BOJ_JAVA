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
                case "push": // push 명령 : 큐 맨 뒤에 push다음 입력된 수 저장
                    queue.add(rear = Integer.parseInt(st.nextToken()));
                    break;
                case "pop": // pop 명령 : 현재 큐에 저장된 원소들 중 가장 먼저 저장된 원소 삭제 및 반환
                    sb.append((queue.isEmpty() ? -1 : queue.remove())+"\n");
                    break;
                case "size": // size 명령 : 큐에 저장된 원소의 갯수 확인
                    sb.append(queue.size()+"\n");
                    break;
                case "empty": // empty 명령 : 큐가 비어있는지 확인(비어있으면 1, 그렇지 않으면 0)
                    sb.append((queue.isEmpty() ? 1 : 0)+"\n");
                    break;
                case "front": // front 명령 : 제일 처음 들어간 값이 무엇인지 출력, 큐가 비어있으면 -1출력
                    sb.append((queue.isEmpty() ? -1 : queue.peek())+"\n");
                    break;
                case "back": // back 명령 : 제일 마지막에 넣은 값이 무엇인지 출력, 큐가 비어있으면 -1출력
                    sb.append((queue.isEmpty() ? -1 : rear)+"\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
