/**
    백준 1436번 - 영화감독 숌
    https://www.acmicpc.net/problem/1436
    
    알고리즘 분류
        1. 브루트포스 알고리즘
*/
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int result = 665;
        while(num > 0)
            if(Integer.toString(++result).contains("666"))
                num--;
        System.out.println(result);
    }
}
