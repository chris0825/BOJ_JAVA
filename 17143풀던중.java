import java.util.*;
import java.io.*;

public class Main {
    static int rSize, cSize, angler = 0, sea[][], ans = 0;
    static HashMap<Integer, Shark> shark = new HashMap<>();
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        rSize = Integer.parseInt(st.nextToken());
        cSize = Integer.parseInt(st.nextToken());
        sea = new int[rSize+1][cSize+1];
        int sNum = Integer.parseInt(st.nextToken());
        Shark s;
        for(int i=1; i<=sNum; i++) {
            st = new StringTokenizer(br.readLine());
            s = new Shark(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            shark.put(i, s);
            sea[s.r][s.c] = i;
        }
        while(!shark.isEmpty()) {
            for(int i=1; i<=rSize; i++) {
                for(int j=1; j<=cSize; j++)
                    System.out.print(sea[i][j]+" ");
                System.out.println();
            }
            System.out.println("=================================");
            fishing();
            move();
        }
        System.out.println(ans);
    }
    static class Shark implements Comparable<Shark>{
        int r;
        int c;
        int s;
        int d;
        int z;
        Shark(int row, int col, int speed, int direction, int size) {
            this.r = row;
            this.c = col;
            this.s = speed;
            this.d = direction;
            this.z = size;
        }
        @Override
        public int compareTo(Shark s) {
            return this.r - s.r;
        }
    }
    static void fishing() {
        if(angler < cSize)
            angler++;
        for(int i=1; i<=rSize; i++)
            if(sea[i][angler] != 0) {
                System.out.println("Eating "+sea[i][angler]);
                ans += shark.get(sea[i][angler]).z;
                shark.remove(sea[i][angler]);
                sea[i][angler] = 0;
                return;
            }
    }
    static void move() {
        int after[][] = new int[rSize+1][cSize+1];
        ArrayList<Integer> del = new ArrayList<>();
        int len, spot = 0;
        Shark s;
        for(int key : shark.keySet()) {
            s = shark.get(key);
            System.out.println("d= "+s.d);
            switch(s.d) {
                case 1: // 상
                    spot = s.s % ((rSize-1)*2);
                    if(spot < s.r)
                        s.r -= spot;
                    else {
                        s.r = spot - s.r + 2;
                        if(s.r > rSize)
                            s.r = rSize - (spot - rSize);
                        else
                            s.d = 2;
                    }
                    break;
                case 2: // 하
                    spot = s.s % ((rSize-1)*2);
                    if(spot <= rSize - s.r)
                        s.r += spot;
                    else {
                        s.r = rSize - (spot - rSize + s.r);
                        s.d = 1;
                    }
                    break;
                case 3: // 우
                    spot = s.s % ((cSize-1)*2);
                    if(spot <= cSize - s.c)
                        s.c += spot;
                    else {
                        s.c = spot - cSize + s.c;
                        if(s.c > cSize)
                            s.c = spot - cSize + 1;
                        else
                            s.d = 4;
                    }
                    break;
                case 4: // 좌
                    spot = s.s % ((cSize-1)*2);
                    if(spot < s.c)
                        s.c -= spot;
                    else {
                        s.c = spot - s.c + 2;
                        if(s.c < 0)
                            s.c = spot - (s.c-1 + cSize);
                        else
                            s.d = 3;
                        System.out.println("d= "+s.d);
                    }
                    break;
            }
            System.out.println(key);
            if(after[s.r][s.c] == 0) {
                shark.put(key, s);
                after[s.r][s.c] = key;
            }
            else {
                if(shark.get(after[s.r][s.c]).z > s.z)
                    del.add(key);
                else {
                    del.add(after[s.r][s.c]);
                    after[s.r][s.c] = key;
                }
            }
            for(int i=1; i<=rSize; i++) {
                for(int j=1; j<=cSize; j++)
                    System.out.print(after[i][j]+" ");
                System.out.println();
            }
            System.out.println();
        }
        while(!del.isEmpty())
            shark.remove(del.remove(0));
        sea = after;
    }
}
