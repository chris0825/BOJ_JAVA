/**
  백준 1085번 - 직사각형에서 탈출
  https://www.acmicpc.net/problem/1085
  
  알고리즘 분류
    1. 수학
    2. 기하학
*/
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int y = input.nextInt();
        int w = input.nextInt();
        int h = input.nextInt();
        System.out.println(Math.min(Math.min(w-x, h-y), Math.min(x, y)));
    }
}
