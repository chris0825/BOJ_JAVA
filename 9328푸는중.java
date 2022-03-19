import java.util.*;
import java.io.*;

public class Main {
    static int r, c;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tC = Integer.parseInt(br.readLine());
        String haveK;
        while(tC-- > 0) {
            String infoMap[] = br.readLine().split(" ");
            r = Integer.parseInt(infoMap[0]);
            c = Integer.parseInt(infoMap[1]);
            boolean key[] = new boolean[26];
            ArrayList<int[]> doc = new ArrayList<>();
            ArrayList<int[]> door = new ArrayList<>();
            String map[][] = new String[r][c];
            for(int i=0; i<r; i++) {
                map[i] = br.readLine().split("");
                for(int j=0; j<c; j++) {
                    if(map[i][j].charAt(0) == '$') 
                        doc.add(new int[]{i, j});
                    else if(i == 0 || j == 0 || i == r-1 || j == c-1)
                        if(map[i][j].charAt(0) == '.')
                            door.add(new int[]{i, j});
                }
            }
            haveK = br.readLine();
            if(haveK.charAt(0) != '0')
                for(int i=0; i<haveK.length(); i++)
                    key[haveK.charAt(i)-'a'] = true;
        }
    }
    static ArrayList<int[]> unlock[] = new ArrayList[26];
    // 새로운 문 또는 문서 찾는 함수
    static void explorer(ArrayList<int[]> doc, ArrayList<int[]> door, boolean key[], String map[][]) {
        Queue<int[]> q = new LinkedList<>();
        for(int start[] : door)
            q.add(start);
        boolean visited[][] = new boolean[r][c];
        for(int i=0; i<r; i++)
            for(int j=0; j<c; j++)
                if(map[i][j].charAt(0) == '*')
                    visited[i][j] = true;
        int a[];
        while(!q.isEmpty()) {
            a = q.poll();
            visited[a[0]][a[1]] = true;
            if(a[0]+1 < r) {
                if(map[a[0]+1][a[1]].charAt(0) == '.')
                    q.add(new int[]{a[0]+1, a[1]});
                else if(map[a[0]+1][a[1]].charAt(0) >= 'a')
                    key[map[a[0]+1][a[1]].charAt(0)-'a'] = true;
                else if(key[map[a[0]+1][a[1]].charAt(0)-'A']) {
                    map[a[0]+1][a[1]] = ".";
                    q.add(new int[]{a[0]+1, a[1]});
                }
                else
                    unlock.add(new int[]{a[0]+1, a[1]});
            }
            if(a[0]-1 >= 0) {
                if(map[a[0]-1][a[1]].charAt(0) == '.')
                    q.add(new int[]{a[0]-1, a[1]});
                else if(map[a[0]-1][a[1]].charAt(0) >= 'a')
                    key[map[a[0]-1][a[1]].charAt(0)-'a'] = true;
                else if(key[map[a[0]-1][a[1]].charAt(0)-'A'])
                    q.add(new int[]{a[0]-1, a[1]});
                else
                    unlock.add(new int[]{a[0]-1, a[1]});
            }
            if(a[1]+1 < c) {
                if(map[a[0]][a[1]+1].charAt(0) == '.')
                    q.add(new int[]{a[0], a[1]+1});
                else if(map[a[0]][a[1]+1].charAt(0) >= 'a')
                    key[map[a[0]][a[1]+1].charAt(0)-'a'] = true;
                else if(key[map[a[0]][a[1]+1].charAt(0)-'A'])
                    q.add(new int[]{a[0], a[1]+1});
                else
                    unlock.add(new int[]{a[0], a[1]+1});
            }
            if(a[1]-1 >= 0) {
                if(map[a[0]][a[1]-1].charAt(0) == '.')
                    q.add(new int[]{a[0], a[1]-1});
                else if(map[a[0]][a[1]-1].charAt(0) >= 'a')
                    key[map[a[0]][a[1]-1].charAt(0)-'a'] = true;
                else if(key[map[a[0]][a[1]-1].charAt(0)-'A'])
                    q.add(new int[]{a[0], a[1]-1});
                else
                    unlock.add(new int[]{a[0], a[1]-1});
            }
        }
    }
}
