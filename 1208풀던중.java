import java.util.*;
import java.io.*;

public class Main {
    static int cnt = 0, n, s, num[];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        s = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        num = new int[n];
        for(int i=0; i<n; i++)
            num[i] = Integer.parseInt(input[i]);
        Arrays.sort(num);
        ArrayList<Long> subL = new ArrayList<>();
        ArrayList<Long> subR = new ArrayList<>();
        subL.add(0L);
        subR.add(0L);
        sub(0, n/2, 0, subL);
        sub(n/2, n, 0, subR);
        Collections.sort(subL);
        Collections.sort(subR);
        long sum;
        int l = 0, r = subR.size()-1;
        while(l < subL.size() && r >= 0) {
            sum = subL.get(l) + subR.get(r);
            if(sum == s)
                cnt++;
            if(sum > s)
                r--;
            else
                l++;
        }
        System.out.println(s == 0 ? cnt-1 : cnt);
    }
    static void sub(int idx, int end, long sum, ArrayList<Long> sub) {
        if(idx == end)
            return;
        sub(idx+1, end, sum, sub);
        sub.add(sum+num[idx]);
        sub(idx+1, end, sub.get(sub.size()-1), sub);
    }
}

/**
32 1000000
100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000
답 : 129024480
*/
