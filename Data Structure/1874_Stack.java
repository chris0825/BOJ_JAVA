/**
  백준 1874번 - 스택 수열
  https://www.acmicpc.net/problem/1874
  
  알고리즘 분류
    1. 자료 구조
    2. 스택
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int order[] = new int[n];
        for(int i=0; i<n; i++)
            order[i] = Integer.parseInt(br.readLine());
        int num = 1;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            while(num <= order[i]) {
                stack.push(num++);
                sb.append("+\n");
            }
            if(stack.pop() == order[i])
                sb.append("-\n");
            else {
                sb = new StringBuilder("NO");
                break;
            }
        }
        System.out.print(sb);
    }
}
