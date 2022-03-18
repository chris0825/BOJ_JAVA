import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int r, c;
        String haveK;
        while(tC-- > 0) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            boolean key[] = new boolean['z'-'a'+1];
            ArrayList<int[]> doc = new ArrayList<>();
            String map[][] = new String[r][c];
            for(int i=0; i<r; i++) {
                map[i] = br.readLine().split("");
                for(int j=0; j<c; j++)
                    if(map[i][j].charAt(0) == '$')
                        doc.add({i, j});
            }
            haveK = br.readLine();
            for(int i=0; i<haveK.length(); i++)
                key[haveL.charAt(i)-'a'] = true;
            
        }
    }/**
    static int dfs() {
        
    }*/
}
