import java.util.*;
import java.io.*;

public class Main {
    static int size;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        int board[][] = new int[size][size];
        StringTokenizer st;
        for(int i=0; i<size; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }
        int a[][] = up(board);
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++)
                System.out.print(a[i][j]+" ");
            System.out.println();
        }
    }
    static int ans = 0;
    static void backTracking(int cnt, int board[][]) {
        if(cnt == 5) {
            for(int i=0; i<size; i++)
                for(int j=0; j<size; j++)
                    ans = Math.max(ans, board[i][j]);
            return;
        }
        backTracking(cnt+1, up(board));
        backTracking(cnt+1, down(board));
        backTracking(cnt+1, left(board));
        backTracking(cnt+1, right(board));
    }
    static int[][] up(int board[][]) {
        int after[][] = new int[size][size];
        Stack<Integer> stack = new Stack<>();
        int idx;
        for(int c=0; c<size; c++) {
            idx = 0;
            for(int r=size-1; r>=0; r--)
                if(board[r][c] != 0)
                    stack.add(board[r][c]);
            if(stack.size() == 1)
                after[idx][c] = stack.pop();
            while(!stack.isEmpty()) {
                after[idx++][c] = stack.pop();
                if(stack.isEmpty())
                    break;
                if(after[idx-1][c] == stack.peek()) {
                    after[idx-1][c] *= 2;
                    stack.pop();
                }
            }
        }
        return after;
    }
}
