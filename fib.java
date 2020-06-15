import java.util.Scanner;

public class fib {
    public static void main(String[] args) {

        int n=15,i=1,a=1,b=1;
        Scanner sc = new Scanner(System.in);

        while(i<n)
        {
            System.out.println(a);
            a=a+b;
            b=a-b;
            i++;
        }
    }
}
