import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int result = 665;
        while(num > 0)
            if(Integer.toString(++result).contains("666"))
                num--;
        System.out.println(result);
    }
}
