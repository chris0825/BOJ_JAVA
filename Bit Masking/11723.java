/**
  백준 11723번 - 집합
  https://www.acmicpc.net/problem/11723
  
  알고리즘 분류
    1. 구현
    2. 비트 마스킹
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        BitSet bit = new BitSet();
        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken()) {
                case "add":
                    bit.set(Integer.parseInt(st.nextToken()));
                    break;
                case "remove":
                    bit.clear(Integer.parseInt(st.nextToken()));
                    break;
                case "check":
                    bw.write((bit.get(Integer.parseInt(st.nextToken())) ? "1" : "0")+"\n");
                    break;
                case "toggle":
                    int input = Integer.parseInt(st.nextToken());
                    if(bit.get(input))
                        bit.clear(input);
                    else
                        bit.set(input);
                    break;
                case "all":
                    bit.set(1, 21, true);
                    break;
                case "empty":
                    bit = new BitSet();
                    break;
            }
        }
        bw.close();
    }
}
