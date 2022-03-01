/**
  백준 1992번 - 쿼드트리
  https://www.acmicpc.net/problem/1992
  
  알고리즘 분류
    1. 분할 정복
    2. 재귀
*/
import java.io.*;

public class Main {
    static String data[][];
    static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        data = new String[size][size];
        for(int i=0; i<size; i++)
            data[i] = br.readLine().split("");
        zip(0, 0, size);
        System.out.println(sb);
    }
    static void zip(int row, int col, int unit) {
        if(unit < 2)
            sb.append(data[row][col]);
        else {
            if(!isEqual(row, col, unit)) {
                sb.append("(");
                for(int i=row; i<row+unit; i+=unit/2)
                    for(int j=col; j<col+unit; j+=unit/2)
                        zip(i, j, unit/2);
                sb.append(")");
            }
            else
                sb.append(data[row][col]);
        }
    }
    static boolean isEqual(int row, int col, int unit) {
        for(int i=row; i<row+unit; i++)
            for(int j=col; j<col+unit; j++)
                if(data[row][col].charAt(0) != data[i][j].charAt(0))
                    return false;
        return true;
    }
}
