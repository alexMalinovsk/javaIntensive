import java.util.ArrayList;
import java.util.Scanner;

public class MaxSerialNums {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> nums=new ArrayList<>();
        int n,curSer=0,maxSer=0;

        n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            nums.add(sc.nextInt());
            if(nums.get(i)%2!=0)
            {
                curSer++;
            }
            else
            {
                curSer = 0;
            }

            if(curSer>maxSer)
            {
                maxSer=curSer;
            }
        }
        System.out.println(maxSer);
    }
}
