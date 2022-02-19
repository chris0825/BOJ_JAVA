/**
  백준 16236번 - 아기 상어
  https://www.acmicpc.net/problem/16236
  
  알고리즘 분류
    1. 구현
    2. 그래프 이론
    3. 그래프 탐색
    4. 너비 우선 탐색
    5. 시뮬레이션
*/
import java.util.*;
import java.io.*;

public class Main {
    static int size, sSize = 2, sea[][], time[][], mR[] = {1, 0, -1, 0}, mC[] = {0, 1, 0, -1};
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        sea = new int[size][size]; // 바닷속
        Spot shark = new Spot(-1, -1); // 상어의 위치
        for(int i=0; i<size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());
                if(sea[i][j] == 9) { // 상어가 입력되면 그 위치를 상어의 위치로 저장
                    shark.r = i;
                    shark.c = j;
                    sea[i][j] = 0; // 상어의 위치는 따로 저장하여 바닷속 상황에 상어의 위치는 나타나지 않음
                }
            }
        }
        int totT = 0, eCnt = 0;
        Spot min;
        while(true) {
            min = bfs(shark); // 문제의 조건을 만족하는 먹이를 찾아 해당 위치를 변수에 저장
            if(min.r != Integer.MAX_VALUE || min.c != Integer.MAX_VALUE) { // 먹이를 찾은 경우
                eCnt++;
                sea[min.r][min.c] = 0; // 해당 먹이를 먹었으므로 바닷속에서 지움
                shark = min; // 해당 먹이를 먹고 난 후 상어는 해당 먹이가 있던 자리에 위치
                totT += time[min.r][min.c]; // 해당 먹이를 먹는데 이동한 시간을 누적 시간에 더함
                if(eCnt == sSize) { // 만약 상어가 몸집이 커질만큼 먹이를 먹었으면 몸집을 키우고 먹은 먹이의 수 리셋
                    sSize++;
                    eCnt = 0;
                }
            }
            else // 만약 먹이 탐색이 끝났음에도 먹이의 위치가 반환되지 않은 경우
                break; // 먹이탐색을 종료한다
        }
        System.out.println(totT); // 먹을 수 있는 먹이를 다 먹은 후 최종 누적 시간 출력
    }
    static class Spot {
        int r;
        int c;
        Spot(int row, int col) {
            this.r = row;
            this.c = col;
        }
    }
    static Spot bfs(Spot shark) {
        Queue<Spot> queue = new LinkedList<>();
        queue.add(shark); // 상어의 위치를 시작점으로 지정
        Spot s, mv, ans = new Spot(Integer.MAX_VALUE, Integer.MAX_VALUE);
        time = new int[size][size]; // 해당 위치까지의 시간을 저장할 배열 초기화
        int minT = Integer.MAX_VALUE; // 먹이를 먹을 수 있는 최소 시간 저장
        while(!queue.isEmpty()) {
            s = queue.remove();
            for(int i=0; i<4; i++) {
                mv = new Spot(s.r+mR[i], s.c+mC[i]); // 상 하 좌 우 이동
                if(isArea(mv) && canMove(mv)) { // 해당 위치로 이동이 가능
                    time[mv.r][mv.c] = time[s.r][s.c] + 1; // 해당 위치까지 걸린 시간 저장
                    if(time[mv.r][mv.c] > minT) // 해당 위치까지 가는 데 먹이를 먹을 수 있는 최소 시간보다 넘어가면 해당 길은 탐색 X
                        continue;
                    if(sea[mv.r][mv.c] != 0 && sea[mv.r][mv.c] < sSize) { // 해당 위치에 있는 물고기를 상어가 먹을 수 있는 경우
                        if(minT > time[mv.r][mv.c]) { // 이전에 찾았던 시간보다 더 빠른 시간에 먹이를 찾은 경우
                            minT = time[mv.r][mv.c];
                            ans = new Spot(mv.r, mv.c);
                        }
                        else if((ans.r == mv.r && ans.c > mv.c) || ans.r > mv.r) // 이전에 찾은 시간과 동일하지만 문제의 조건에 따라 우선 순위에 있는 먹이
                            ans = new Spot(mv.r, mv.c);
                    }
                    queue.add(mv); // 계속 경로 탐색하기 위해 이동이 가능했던 곳은 다음 방문 예정 루트로 저장
                }
            }
        }
        return ans; // 문제의 조건에 부합하는 우선순위가 가장 높은 먹이의 위치 반환(만약 먹이를 찾지 못하면 Integer.MAX_VALUE값 반환)
    }
  
    // 해당 위치가 바다에 존재하는 위치인지 판단하는 함수
    static boolean isArea(Spot s) {
        return s.r>=0 && s.r<size && s.c>=0 && s.c<size;
    }
  
    // 해당 위치가 상어가 이동할 수 있는 곳인지 판
    static boolean canMove(Spot s) {
        return sea[s.r][s.c] <= sSize && time[s.r][s.c] == 0;
    }
}
