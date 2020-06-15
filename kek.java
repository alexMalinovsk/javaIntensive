import java.util.Scanner;

public class kek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=6423,sum=0;
        for(int i=0;i<=n;i++)
        {
            sum+=i;
        }
        System.out.println(n*n+" - "+sum+" = "+(n*n-sum));
    }
}
