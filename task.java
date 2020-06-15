import java.util.Scanner;

public class task {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        for(int i=0;i<=n/3;i++)
        {
            System.out.println((int)Math.pow(2,i));
        }
    }
}
