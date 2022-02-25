/**
  백준 5525번 - IOIOI
  https://www.acmicpc.net/problem/5525
  
  알고리즘 분류
    1. 문자열
*/
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int cnt = 0, ans = 0;
        for(int i=1; i<m-1; ) {
            if(str.charAt(i) == 'O' && str.charAt(i+1) == 'I') {
                cnt++;
                if(cnt == n) {
                    if(str.charAt(i-(cnt*2-1)) == 'I')
                        ans++;
                    cnt--;
                }
                i += 2;
            }
            else {
                cnt = 0;
                i++;
            }
        }
        System.out.println(ans);
    }
}
