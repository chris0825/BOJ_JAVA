import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aNum = Integer.parseInt(st.nextToken());
        int memory = Integer.parseInt(st.nextToken());
        int app[][] = new int[aNum+1][2];
        for(int j=1; j>=0; j--) {
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=aNum; i++)
                app[i][j] = Integer.parseInt(st.nextToken());
            }
        System.out.println(knapsack(aNum, memory));
    }
    static int knapsack(int aNum, int memory) {
        int backpack[][] = new int[aNum+1][memory+1];
        for(int i=1; i<=aNum; i++) {
            for(int j=1; j<=memory; j++) {
                if(app[i].weight <= j)
                    backpack[i][j] = Math.max(app[i-1].cost + app[i-1][j-app[i-1].weight], app[i-1][j]);
                else
                    backpack[i][j] = backpack[i-1][j];
            }
        }
        return backpack[aNum][memory];
    }
}
