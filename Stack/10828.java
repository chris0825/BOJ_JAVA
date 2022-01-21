/**
  백준 10828번 - 스택
  https://www.acmicpc.net/problem/10828
  
  알고리즘 분류
    1. 자료구조
    2. 스택
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<String> stack = new Stack<>();
        int remoteNum = Integer.parseInt(br.readLine());
        while(remoteNum-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "push":
                    stack.push(st.nextToken());
                    break;
                case "pop":
                    if(stack.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(stack.pop()+"\n");
                    break;
                case "size":
                    bw.write(String.valueOf(stack.size())+"\n");
                    break;
                case "empty":
                    if(stack.isEmpty())
                        bw.write("1\n");
                    else
                        bw.write("0\n");
                    break;
                case "top":
                    if(stack.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(stack.peek()+"\n");
                    break;
            }
        }
        bw.close();
    }
}
