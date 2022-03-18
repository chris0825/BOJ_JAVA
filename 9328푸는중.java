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
            String map[] = new String[r];
            for(int i=0; i<r; i++) {
                map[i] = br.readLine();
                for(int j=0; j<c; j++) {
                    if(map[i].charAt(j) == '$') 
                        doc.add(new int[]{i, j});
                    else if(i == 0 || j == 0 || i == r-1 || j == c-1)
                        if(map[i].charAt(j) == '.')
                            door.add(new int[]{i, j});
                }
            }
            haveK = br.readLine();
            if(haveK.charAt(0) != '0')
                for(int i=0; i<haveK.length(); i++)
                    key[haveK.charAt(i)-'a'] = true;
        }
    }
    static void findK(String map[], boolean key[], ArrayList<int[]> doc, ArrayList<int[]> door) {
        Queue<int[]> q = new LinkedList<>();
        for(int start[] : door)
            q.add(start);
        boolean visited[][] = new boolean[r][c];
        for(int i=0; i<r; i++)
            for(int j=0; j<c; j++)
                if(map[i].charAt(j) == '*')
                    visited[i][j] = true;
        ArrayList<Chracter> key = new ArrayList<>();
        int a[];
        while(!q.isEmpty()) {
            a = q.poll();
            visited[a[0]][a[1]] = true;
            if(a[0]+1 < r) {
                if(map[a[0]+1].charAt(a[1]) == '.')
                    q.add(new int[]{a[0]+1, a[1]});
                else if(map[a[0]+1].charAt(a[1]) >= 'a')
                    key[map[a[0]+1].charAt(a[1])-'a'] = true;
                else if(key[map[a[0]+1].charAt(a[1])-'A']) {
                    map[a[0]+1].charAt(a[1]) = '.';
                    q.add(new int[]{a[0]+1, a[1]});
                }
            }
            if(a[0]-1 >= 0) {
                if(map[a[0]-1].charAt(a[1]) == '.')
                    q.add(new int[]{a[0]-1, a[1]});
                else if(map[a[0]-1].charAt(a[1]) >= 'a')
                    key[map[a[0]-1].charAt(a[1])-'a'] = true;
                else if(key[map[a[0]-1].charAt(a[1])-'A'])
                    q.add(new int[]{a[0]-1, a[1]});
            }
            if(a[1]+1 < c) {
                if(map[a[0]].charAt(a[1]+1) == '.')
                    q.add(new int[]{a[0], a[1]+1});
                else if(map[a[0]].charAt(a[1]+1) >= 'a')
                    key[map[a[0]].charAt(a[1]+1)-'a'] = true;
                else if(key[map[a[0]].charAt(a[1]+1)-'A'])
                    q.add(new int[]{a[0], a[1]+1});
            }
            if(a[1]-1 >= 0) {
                if(map[a[0]].charAt(a[1]-1) == '.')
                    q.add(new int[]{a[0], a[1]-1});
                else if(map[a[0]].charAt(a[1]-1) >= 'a')
                    key[map[a[0]].charAt(a[1]-1)-'a'] = true;
                else if(key[map[a[0]].charAt(a[1]-1)-'A'])
                    q.add(new int[]{a[0], a[1]-1});
            }
        }
        if(key.size() != 0) {
            findK();
        }
    }
}
