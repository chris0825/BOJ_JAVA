/**
  백준 5430번 - AC (Deque VER.)
  https://www.acmicpc.net/problem/5430
  
  알고리즘 분류
    1. 구현
    2. 자료구조
    3. 문자열
    4. 파싱
    5. 덱
*/
import java.util.*;
import java.io.*;

public class Main {
    static boolean isR;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tC = Integer.parseInt(br.readLine());
        String command;
        int size;
        String input;
        Deque<String> list = new ArrayDeque<>();
        while(tC-- > 0) {
            command = br.readLine();
            size = Integer.parseInt(br.readLine());
            input = br.readLine();
            StringTokenizer st = new StringTokenizer(input.substring(1, input.length()-1), ",");
            for(int i=0; i<size; i++)
                list.add(st.nextToken());
            bw.write(ac(command, list)+"\n");
            list.clear();
        }
        bw.close();
    }
    static String ac(String command, Deque<String> list) {
        isR = false;
        for(int i=0; i<command.length(); i++) {
            switch(command.charAt(i)) {
                case 'R':
                    isR = !isR;
                    break;
                case 'D':
                    if(list.isEmpty())
                        return "error";
                    else {
                        if(isR)
                            list.removeLast();
                        else
                            list.removeFirst();
                    }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if(isR) {
            while(!list.isEmpty()) {
                sb.append(list.removeLast());
                if(!list.isEmpty())
                    sb.append(",");
            }
        }
        else {
            while(!list.isEmpty()) {
                sb.append(list.pop());
                if(!list.isEmpty())
                    sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
