/**
  백준 1259번 - 팰린드롬수
  https://www.acmicpc.net/problem/1259
  
  알고리즘 분류
    1. 구현
    2. 문자열
*/
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String num = br.readLine();
        while(!num.equals("0")){
            if(num.length() == 1)
                bw.write("yes\n");
            else{
                for(int i=0; i<num.length()/2; i++){
                    if(num.charAt(i) != num.charAt(num.length()-i-1)){
                        bw.write("no\n");
                        break;
                    }
                    else if(i == num.length()/2 -1)
                        bw.write("yes\n");
                }
            }
            num = br.readLine();
        }
        bw.close();
    }
}
