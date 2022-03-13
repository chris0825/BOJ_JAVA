import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int nth = input.nextInt();
        int num = 665, len, cnt = 0;
        while(nth > 0) {
            num++;
            len = (int)(Math.log10(num)+1);
            for(int i=len-1; i>=0; i--) {
                if(num%(int)Math.pow(10, i+1)/(int)(Math.pow(10, i)) == 6) {
                    cnt++;
                    if(cnt == 3) {
                        nth--;
                        cnt = 0;
                        break;
                    }
                }
                else
                    cnt = 0;
            }
        }
        System.out.println(num);
    }
}
