import java.util.*;
import java.io.*;

public class Main {
    static int rSize, cSize, angler = 0, sea[][];
    static HashMap<Integer, Shark> shark = new HashMap<>();
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        rSize = Integer.parseInt(st.nextToken())+1;
        cSize = Integer.parseInt(st.nextToken())+1;
        sea = new int[rSize][cSize];
        int sNum = Integer.parseInt(st.nextToken());
        Shark s;
        for(int i=1; i<=sNum; i++) {
            st = new StringTokenizer(br.readLine());
            s = new Shark(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            shark.put(i, s);
            sea[s.r][s.c] = i;
        }
        while(!shark.isEmpty()) {
            fishing();
            move();
        }
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
        for(int i=1; i<rSize; i++)
            if(sea[angler][i] != 0) {
                shark.remove(sea[angler][i]);
                sea[angler][i] = 0;
                return;
            }
    }
    static void move() {
        int after[][] = new int[rSize][cSize];
        int len, spot = 0;
        Shark s;
        for(int key : shark.keySet()) {
            s = shark.get(key);
            switch(s.d) {
                case 1: // 상
                    len = rSize-1;
                    spot = s.r - 1 - s.s % ((len-1)*2);
                    if(spot >= 0)
                        s.r -= spot;
                    else {
                        s.r = (spot + s.r - 1)*(-1);
                        s.d = 2;
                    }
                    break;
                case 2: // 하
                    len = rSize-1;
                    spot = len - s.r - s.s % ((len-1)*2);
                    if(spot >= 0)
                        s.r += spot;
                    else {
                        s.r = (spot - len + s.r)*(-1);
                        s.d = 1;
                    }
                    break;
                case 3: // 우
                    len = cSize-1;
                    spot = len - s.c - s.s % ((len-1)*2);
                    if(spot >= 0)
                        s.c += spot;
                    else {
                        s.c = (spot - len + s.c)*(-1);
                        s.d = 4;
                    }
                    break;
                case 4: // 좌
                    len = cSize-1;
                    spot = s.c - 1 - s.s % ((len-1)*2);
                    if(spot >= 0)
                        s.c -= spot;
                    else {
                        s.c = (spot + s.c - 1)*(-1);
                        s.d = 3;
                    }
                    break;
            }
            System.out.println(s.d+" "+spot);
            if(after[s.r][s.c] == 0)
                shark.put(key, s);
            else {
                if(shark.get(after[s.r][s.c]).z > s.z)
                    shark.remove(key);
                else {
                    shark.remove(after[s.r][s.c]);
                    sea[s.r][s.c] = key;
                }
            }
        }
        sea = after;
    }
}
