/**
  백준 9019번 - DSLR
  https://www.acmicpc.net/problem/9019
  
  알고리즘 분류
    1. 그래프 이론
    2. 그래프 탐색
    3. 너비 우선 탐색
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tC = Integer.parseInt(br.readLine());
        int a, b;
        while(tC-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());   
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            bw.write(bfs(a, b)+"\n");
        }
        bw.close();
    }
    static String bfs(int a, int b) {
        Queue<Integer> queue = new LinkedList<>();
        String command[] = new String[10000];
        queue.add(a);
        command[a] = "";
        int temp, d, s, l, r;
        while(!queue.isEmpty() && command[b] == null) {
            temp = queue.remove();
            d = (temp * 2) % 10000;
            s = temp == 0 ? 9999 : temp-1;
            l = temp % 1000 * 10 + temp / 1000;
            r = temp % 10 * 1000 + temp / 10;
            if(command[d] == null) {
                queue.add(d);
                command[d] = command[temp] + "D";
            }
            if(command[s] == null) {
                queue.add(s);
                command[s] = command[temp] + "S";
            }
            if(command[l] == null) {
                queue.add(l);
                command[l] = command[temp] + "L";
            }
            if(command[r] == null) {
                queue.add(r);
                command[r] = command[temp] + "R";
            }
        }
        return command[b];
    }
}
