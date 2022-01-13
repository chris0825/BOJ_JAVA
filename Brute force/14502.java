/**
  백준 14502번 - 연구소
  
  알고리즘
    1. 그래프 이론
    2. 브루트 포스
    3. 그래프 탐색
    4. 너비 우선 탐색
*/
import java.util.*;
import java.io.*;
public class Main {
    static int row, col;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer init = new StringTokenizer(br.readLine());
        row = Integer.parseInt(init.nextToken());
        col = Integer.parseInt(init.nextToken());
        String space[][] = new String[row][col];
        for(int i=0; i<row; i++)
            space[i] = br.readLine().split(" ");
        System.out.println(dfs(space));
    }
    static class Spot {
        int row;
        int col;
        Spot(int r, int c) {
            this.row = r;
            this.col = c;
        }
    }
    static int bfs(int space[][]) {
        Queue<Spot> queue = new LinkedList<>();
        int spreadV[][] = new int[row][col];
        for(int i=0; i<row; i++)
            for(int j=0; j<col; j++) {
                if(space[i][j] == 2) {
                    queue.add(new Spot(i, j));
                    spreadV[i][j] = 2;
                }
                else if(space[i][j] == 1)
                    spreadV[i][j] = 1;
            }
        int mR[] = {-1, 0, 1, 0};
        int mC[] = {0, 1, 0, -1};
        Spot s;
        int r, c;
        while(!queue.isEmpty()) {
            s = queue.remove();
            for(int i=0; i<4; i++) {
                r = s.row + mR[i];
                c = s.col + mC[i];
                if(isArea(r, c) && spreadV[r][c] == 0) {
                    queue.add(new Spot(r, c));
                    spreadV[r][c] = 2;
                }
            }
        }
        int cnt = 0;
        for(int i=0; i<row; i++)
            for(int j=0; j<col; j++)
                if(spreadV[i][j] == 0)
                    cnt++;
        return cnt;
    }
    static int dfs(String space[][]) {
        ArrayList<Spot> bList = new ArrayList<>();
        int buildB[][] = new int[row][col];
        for(int i=0; i<row; i++)
            for(int j=0; j<col; j++) {
                if(space[i][j].equals("0"))
                    bList.add(new Spot(i, j));
                else
                    buildB[i][j] = Integer.parseInt(space[i][j]);
            }
        int safeMax = 0;
        for(int i=0; i<bList.size()-2; i++) {
            buildB[bList.get(i).row][bList.get(i).col] = 1;
            for(int j=i+1; j<bList.size()-1; j++) {
                buildB[bList.get(j).row][bList.get(j).col] = 1;
                for(int k=j+1; k<bList.size(); k++) {
                    buildB[bList.get(k).row][bList.get(k).col] = 1;
                    safeMax = Math.max(safeMax, bfs(buildB));
                    buildB[bList.get(k).row][bList.get(k).col] = 0;
                }
                buildB[bList.get(j).row][bList.get(j).col] = 0;
            }
            buildB[bList.get(i).row][bList.get(i).col] = 0;
        }
        return safeMax;
    }
    static boolean isArea(int i, int j) {
        return i>=0 && i<row && j>=0 && j<col;
    }
}
