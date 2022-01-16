/**
  백준 1003번 - 피보나치 함수
  https://www.acmicpc.net/problem/1003
  
  알고리즘
    1. 다이나믹 프로그래밍
*/
import java.io.*;

public class Main {
    static int cnt0, cnt1;
    static int fibo[][] = new int[41][2];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tC = Integer.parseInt(br.readLine());
        int n;
        for(int i=0; i<tC; i++){
            cnt0 = 0;
            cnt1 = 0;
            n = Integer.parseInt(br.readLine());
            fibonacci(n);
            bw.write(fibo[n][0]+" "+fibo[n][1]+"\n");
        }
        bw.close();
    }
    static int[] fibonacci(int n) {
        if(n == 0)
            fibo[0][0] = 1;
        else if(n == 1)
            fibo[1][1] = 1;
        else if(fibo[n][0] == 0 && fibo[n][1] == 0) {
            fibo[n][0] = fibonacci(n-1)[0] + fibonacci(n-2)[0];
            fibo[n][1] = fibonacci(n-1)[1] + fibonacci(n-2)[1];
        }
        return fibo[n];
    }
}
