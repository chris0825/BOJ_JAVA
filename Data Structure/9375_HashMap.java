/**
  백준 9375번 - 패션왕 신해빈
  https://www.acmicpc.net/problem/9375
  
  알고리즘 분류
    1. 수학
    2. 자료 구조
    3. 해시를 사용한 집합과 맵
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tC = Integer.parseInt(br.readLine());
        int cNum, cases;
        String cloth[] = new String[2];
        while(tC-- > 0) {
            HashMap<String, Integer> coordi = new HashMap<>(); // 옷 종류별로 몇벌인지 저장할 맵
            cNum = Integer.parseInt(br.readLine());
            cases = 1;
            while(cNum-- > 0) {
                cloth = br.readLine().split(" ");
                if(coordi.containsKey(cloth[1])) // 해당 종류의 옷이 저장되어 있는 경우
                    coordi.put(cloth[1], coordi.get(cloth[1])+1); // 개수 +1
                else
                    coordi.put(cloth[1], 2); // 해당 종류의 옷이 최초 입력인 경우(해당 종류의 옷이 선택되지 않을 경우도 포함해야 하기 때문에 2개로 등록)
            }
            for(String key : coordi.keySet()) // 모든 경우의 수 구하기
                cases *= coordi.get(key);
            bw.write((cases-1)+"\n"); // 알몸인 상태는 제외이므로 결괏값에서 -1한 값이 정답
        }
        bw.close();
    }
}
