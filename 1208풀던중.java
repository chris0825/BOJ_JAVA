import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nNum = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new long[nNum];
        for(int i=0; i<nNum; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        subSum(s, 0, nNum/2, subL);
        subSum(s, nNum/2, nNum, subR);
        Collections.sort(subL);
        Collections.sort(subR);
        int l = 0, r = subR.size()-1, subCnt = 0, subLCnt, subRCnt;
        long sum;
        while(l < subL.size() && r >= 0) {
            sum = subL.get(l) + subR.get(r);
            if(s == sum) {
                subLCnt = subRCnt = 1;
                while(l < subL.size()-1 && subL.get(l) == subL.get(++l))
                    subLCnt++;
                while(r > 0 && subR.get(r) == subR.get(--r))
                    subRCnt++;
                subCnt += subLCnt * subRCnt;
            }
            else if(s > sum)
                l++;
            else
                r--;
        }
        System.out.println(s == 0 ? subCnt-1 : subCnt);
    }
    static long arr[];
    static ArrayList<Long> subL = new ArrayList<>();
    static ArrayList<Long> subR = new ArrayList<>();
    static void subSum(long s, int start, int end, ArrayList<Long> sub) {
        if(start == end) {
            sub.add(s);
            return;
        }
        subSum(s, start+1, end, sub);
        subSum(s+arr[start], start+1, end, sub);
    }
}
