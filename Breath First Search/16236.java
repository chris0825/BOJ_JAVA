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
    static int size = 0, shark = 2, minR, minC, minT, eCNT=0, sea[][], time[][];
    static int mR[] = {1, 0, -1, 0};
    static int mC[] = {0, 1, 0, -1};
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        sea = new int[size][size];
        Spot sSpot = new Spot(-1, -1);
        for(int i=0; i<size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());
                if(sea[i][j] == 9) {
                    sSpot.row = i;
                    sSpot.col = j;
                    sea[i][j] = 0;
                }
            }
        }
        int totTime = 0;
        while(true) {
            time = new int[size][size];
            minT = minR = minC = Integer.MAX_VALUE;
            bfs(sSpot);
            if(minR != Integer.MAX_VALUE && minC != Integer.MAX_VALUE) {
                eCNT++;
                sea[minR][minC] = 0;
                sSpot.row = minR;
                sSpot.col = minC;
                totTime += time[minR][minC];
                if(eCNT == shark) {
                    shark++;
                    eCNT = 0;
                }
            }
            else
                break;
        }
        System.out.println(totTime);
    }
    static class Spot {
        int row;
        int col;
        Spot(int r, int c) {
            this.row = r;
            this.col = c;
        }
    }
    static void bfs(Spot sSpot) {
        Queue<Spot> queue = new LinkedList<>();
        queue.add(sSpot);
        Spot s;
        int r, c;
        while(!queue.isEmpty()) {
            s = queue.remove();
            for(int i=0; i<4; i++) {
                r = s.row + mR[i];
                c = s.col + mC[i];
                if(r>=0 && r<size && c>=0 && c<size && sea[r][c] <= shark && time[r][c] == 0) {
                    time[r][c] = time[s.row][s.col] + 1;
                    if(sea[r][c] != 0 && sea[r][c] < shark) {
                        if(minT > time[r][c]) {
                            minT = time[r][c];
                            minR = r;
                            minC = c;
                        }
                        else if(minT == time[r][c] && ((minR == r && minC > c) || minR > r)) {
                            minR = r;
                            minC = c;
                        }
                    }
                    queue.add(new Spot(r, c));       
                }
            }
        }
    }
}
