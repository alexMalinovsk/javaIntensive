import java.util.Scanner;

public class neg {
    public static void main(String[] args) {
        int n1, n2, n3, n4;
        Scanner sc = new Scanner(System.in);
        n1 = sc.nextInt();
        n2 = sc.nextInt();
        n3 = sc.nextInt();
        n4 = sc.nextInt();

        if (n1 != n2) {
            if (n1 == n3)
                System.out.println(2);
            else
                System.out.println(1);
        } else {
            if (n1 == n3)
                System.out.println(4);
            else
                System.out.println(3);
        }
    }
}
