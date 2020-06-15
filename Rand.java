import java.util.Random;
import java.util.Scanner;

public class Rand {
    public static void main(String[] args) {
        int n;
        Random r=new Random();
        Scanner sc = new Scanner(System.in);
        n=r.nextInt(2);
        if(n==0)
        System.out.println("You flipped back");
        else
        System.out.println("You flipped heads");
    }
}
