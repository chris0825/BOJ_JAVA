/**
  백준 1931번 - 회의실 배정
  https://www.acmicpc.net/problem/1931
  
  알고리즘 분류
    1. 그리디 알고리즘
    2. 정렬
*/
// 1. 2차원 배열 사용
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int mt[][] = new int[n][2];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            mt[i][0] = Integer.parseInt(st.nextToken());
            mt[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(mt, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });
        int cnt = 0, eT = 0;
        for(int i=0; i<n; i++)
            if(eT <= mt[i][0]) {
                eT = mt[i][1];
                cnt++;
            }
        System.out.println(cnt);
    }
}

// 2. 클래스 선언해서 사용
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Meeting mt[] = new Meeting[n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            mt[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(mt);
        int cnt = 0, eT = 0;
        for(int i=0; i<n; i++)
            if(eT <= mt[i].sT) {
                eT = mt[i].eT;
                cnt++;
            }
        System.out.println(cnt);
    }
    static class Meeting implements Comparable<Meeting>{
        int sT;
        int eT;
        Meeting (int s, int e) {
            this.sT = s;
            this.eT = e;
        }
        @Override
        public int compareTo(Meeting m) {
            if(this.eT == m.eT)
                return this.sT - m.sT;
            return this.eT - m.eT;
        }
    }
}
