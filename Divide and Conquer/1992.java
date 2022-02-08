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
    static int size;
    static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        if(size == 1)
            System.out.println(br.readLine());
        else {
            data = new String[size][size];
            for(int i=0; i<size; i++)
                data[i] = br.readLine().split("");
            zip(0, 0, size);
            System.out.println(sb);
        }
    }
    static void zip(int col, int row, int unit) {
        if(unit < 2)
            sb.append(data[col][row]);
        else {
            for(int i=col; i<col+unit; i++)
                for(int j=row; j<row+unit; j++)
                    if(!data[col][row].equals(data[i][j])) {
                        sb.append("(");
                        zip(col, row, unit/2);
                        zip(col, row+unit/2, unit/2);
                        zip(col+unit/2, row, unit/2);
                        zip(col+unit/2, row+unit/2, unit/2);
                        sb.append(")");
                        return;
                    }
            sb.append(data[col][row]);
        }
    }
}
