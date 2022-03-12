import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> incSeq = new ArrayList<>();
        int num[] = new int[n], idxL[] = new int[n], low, high, mid;
        StringTokenizer st = new StringTokenizer(br.readLine());
        incSeq.add(num[0] = Integer.parseInt(st.nextToken()));
        idxL[0] = 0;
        for(int i=1; i<n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            if(incSeq.get(incSeq.size()-1) < num[i])
                incSeq.add(num[i]);
            else {
                idxL[i] = Collections.binarySearch(incSeq, num[i]);
                if(idxL[i] >= 0)
                    continue;
                else
                    incSeq.set(idxL[i]=Math.abs(idxL[i]+1), num[i]);
            }
        }
        bw.write(incSeq.size()+"\n");
        for(int value : incSeq)
            bw.write(value+" ");
        bw.close();
    }
}
