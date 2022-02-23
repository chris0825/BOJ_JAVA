/**
  백준 7662번 - 이중 우선순위 큐
  https://www.acmicpc.net/problem/7662
  
  알고리즘 분류
    1. 자료 구조
    2. 트리를 사용한 집합과 맵
    3. 우선순위 큐
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tC = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> tM = new TreeMap<>();
        int k, num;
        while(tC-- > 0) {
            k = Integer.parseInt(br.readLine());
            while(k-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                switch(st.nextToken()){
                    case "I":
                        num = Integer.parseInt(st.nextToken());
                        tM.put(num, tM.getOrDefault(num, 0) + 1);
                        break;
                    case "D":
                        if(tM.size() > 0) {
                            num = Integer.parseInt(st.nextToken()) == 1 ? tM.lastKey() : tM.firstKey();
                            if(tM.put(num, tM.get(num) - 1) == 1)
                                tM.remove(num);
                        }
                        break;
                }
            }
            bw.write(tM.size() == 0 ? "EMPTY\n" : tM.lastKey()+" "+tM.firstKey()+"\n");
            tM.clear();
        }
        bw.close();
    }
}
