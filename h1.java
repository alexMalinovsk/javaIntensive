import java.util.Scanner;

public class h1 {
    public static void main(String[] args) {
        int[] num=new int[10];
        int n=0;
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<num.length;i++)
        {
            num[i]=sc.nextInt();
            n+=num[i];
        }
        System.out.println(n);
    }
}
