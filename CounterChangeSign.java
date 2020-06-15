import java.util.ArrayList;
import java.util.Scanner;

public class CounterChangeSign {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> nums=new ArrayList<>();
        int n,counter=0;

        n=sc.nextInt();
        if(n>0)
            nums.add(sc.nextInt());
        for(int i=1;i<n;i++)
        {
            nums.add(sc.nextInt());
            if((nums.get(i-1)>=0 && nums.get(i)<0) || (nums.get(i-1)<0 && nums.get(i)>=0))
            {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
