해당 문제 원소의 최솟값은 음수이므로, 처음 memo[0] 값을 비교할 때 초기값을 (해당 원소의 최솟값-1)로 설정해준다. memo[0] = -1,000,000,001

다음에 올 숫자(arr[i])가 현재 마지막 값 중 최솟값(memo[len])이랑 비교한다. 
if(arr[i] > memo[len]) LIS 조건이 성립하므로 값을 넣어주고 len을 1 늘려준다. memo[len+1] = num
1번에 해당되지 않을 경우, 다음에 올 숫자(arr[i])가 수열의 최솟값과 최댓값 사이의 값이므로 이진탐색을 통해 삽입할 idx를 찾는다.
현재 memo={1,2,7}이고 arr[i] = 3이면, 이는 1,2,7보다는 뒤에 등장하는 수이고 또 1,2보다 크기보다는 크고 7보다는 작은 값이다.
그러므로 이진탐색을 통해 memo[i-1] < num <= memo[i]인 곳을 찾아 memo[i] = num을 갱신해준다.
최종적으로 탐색을 진행하면서 num에 따라 해당 조건을 넣어주면 된다.
    
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int num[] = new int[n], idx, lis[] = new int[n+1], len = 0, dp[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            num[i] = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++) {
            if(lis[len] < num[i]) {
                dp[i] = ++len;
                lis[len] = num[i];
            }
            else {
                idx = Arrays.binarySearch(lis, num[i]);
                if(idx < 0)
                    idx = Math.abs(idx+2);
                lis[idx] = num[i];
                dp[i] = idx;
            }
        }
        bw.write(len+"\n");
        Stack<Integer> s = new Stack<>();
        for(int i=n-1; i>=0; i--)
            if(dp[i] == len) {
                s.push(num[i]);
                len--;
            }
        while(!s.isEmpty())
            bw.write(s.pop()+" ");
        bw.close();
    }
}
