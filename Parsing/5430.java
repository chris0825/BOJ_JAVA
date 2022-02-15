/**
  백준 5430번 - AC (Parsing VER.)
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
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tC = Integer.parseInt(br.readLine());
        String command, input, nList[];
        int size;
        while(tC-- > 0) {
            command = br.readLine();
            size = Integer.parseInt(br.readLine());
            input = br.readLine();
            nList = input.substring(1, input.length()-1).split(",");
            bw.write(ac(command, nList, size)+"\n");
        }
        bw.close();
    }
    static String ac(String command, String nList[], int size) {
        int start = 0, end = size-1;
        boolean isR = false;
        for(int i=0; i<command.length(); i++) {
            switch(command.charAt(i)) {
                case 'R':
                    isR = !isR;
                    break;
                case 'D':
                    if(start > end)
                        return "error";
                    else {
                        if(isR)
                            end--;
                        else
                            start++;
                    }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if(isR) {
            for(int i=end; i>=start; i--) {
                sb.append(nList[i]);
                if(i != start)
                    sb.append(",");
            }
        }
        else {
            for(int i=start; i<=end; i++) {
                sb.append(nList[i]);
                if(i != end)
                    sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
