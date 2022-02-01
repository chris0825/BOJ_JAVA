/**
  백준 1541번 - 잃어버린 괄호
  https://www.acmicpc.net/problem/1541
  
  알고리즘 분류
    1. 수학
    2. 문자열
    3. 그리디 알고리즘
    4. 파싱
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        ArrayList<Integer> numL = new ArrayList<>();
        ArrayList<Character> operate = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++)
            if(str.charAt(i)-'0' >= 0)
                sb.append(str.charAt(i));
            else {
                if(sb.length() != 0)
                    numL.add(Integer.parseInt(sb.toString()));
                sb.delete(0, sb.length());
                operate.add(str.charAt(i));
            }
        numL.add(Integer.parseInt(sb.toString()));
        int result = numL.get(0);
        for(int i=1; i<numL.size(); i++)
            switch(operate.get(i-1)) {
                case '+':
                    result += numL.get(i);
                    break;
                case '-':
                    for(; i<numL.size(); i++)
                        result -= numL.get(i);
                    break;
            }
        System.out.println(result);
    }
}
