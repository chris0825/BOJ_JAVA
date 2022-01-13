/**
  백준 1991번 - 트리 순회
  https://www.acmicpc.net/problem/1991
  
  알고리즘
    1. 트리
    2. 재귀
*/
import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static HashMap<Integer, String> order = new HashMap<>();
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> tree = new HashMap<>();
        String temp;
        int p_idx = 1;
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                temp = st.nextToken();
                if(j == 0) {
                    if(i == 0) {
                        tree.put(temp, 1);
                        order.put(1, temp);
                    }
                    else
                        p_idx = tree.get(temp);
                }
                else if(!temp.equals(".")) {
                    tree.put(temp, p_idx*2+j-1);
                    order.put(p_idx*2+j-1, temp);
                }
            }
        }
        bw.write(preOrder(1)+"\n");
        bw.write(inOrder(1)+"\n");
        bw.write(postOrder(1)+"\n");
        bw.close();
    }
    static StringBuilder preOrder(int idx) {
        StringBuilder sb = new StringBuilder();
        sb.append(order.get(idx));
        if(order.get(idx*2) != null)
            sb.append(preOrder(idx*2));
        if(order.get(idx*2+1) != null)
            sb.append(preOrder(idx*2+1));
        return sb;
    }
    static StringBuilder inOrder(int idx) {
        StringBuilder sb = new StringBuilder();
        if(order.get(idx*2) != null)
            sb.append(inOrder(idx*2));
        sb.append(order.get(idx));
        if(order.get(idx*2+1) != null)
            sb.append(inOrder(idx*2+1));
        return sb;
    }
    static StringBuilder postOrder(int idx) {
        StringBuilder sb = new StringBuilder();
        if(order.get(idx*2) != null)
            sb.append(postOrder(idx*2));
        if(order.get(idx*2+1) != null)
            sb.append(postOrder(idx*2+1));
        sb.append(order.get(idx));
        return sb;
    }
}
