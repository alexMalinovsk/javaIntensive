import java.util.Scanner;

public class summ {
    public static void main(String[] args) {
        int  sum = 1,n=10;

        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= n; i++) {
            System.out.println("+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
            for (int j = 1; j <= n; j++)
            {
                System.out.print("|\t"+i*j+"\t");
            }
            System.out.println("|");
        }

       // System.out.println(sum);
    }
}
