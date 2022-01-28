/**
  백준 1697번 - 숨바꼭질
  https://www.acmicpc.net/problem/1697
  
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int subin = Integer.parseInt(st.nextToken());
        int sister = Integer.parseInt(st.nextToken());
        System.out.println(hideAseek(subin, sister));
    }
    static int hideAseek(int start, int end) {
        Queue<Integer> queue = new LinkedList<>(); // 다음 경로를 저장할 큐
        queue.add(start);
        int second[] = new int[100001]; // 경로 탐색에 걸린 시간 저장할 배열
        second[start] = 1;
        // 시작 위치는 시간이 0이어야 맞지만 1로 저장해두는 이유는 0이면 방문 유무를 체크 할 때 방문하지 않았다고 판단되기 때문에 1로 시작한다.
        int temp;
        while(!queue.isEmpty()) {
            temp = queue.remove();
            if(temp-1 >= 0 && second[temp-1] == 0) { // -1칸 이동
                queue.add(temp-1);
                second[temp-1] = second[temp] + 1;
            }
            if(temp*2 <= 100000 && second[temp*2] == 0) { // X2칸 이동
                queue.add(temp*2);
                second[temp*2] = second[temp] + 1;
            }
            if(temp+1 <= 100000 && second[temp+1] == 0) { // +1칸 이동
                queue.add(temp+1);
                second[temp+1] = second[temp] + 1;
            }
            if(second[end] != 0) // 동생의 위치를 찾았다면 경로 탐색 종료
                break;
        }
        return second[end]-1; // 시작 위치의 시간을 1로 시작했기 때문에 해당 시간만큼 결과값에서 빼줘야 맞는 시간이 된다.
    }
}
