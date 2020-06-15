package Next;

import java.util.Random;

public class FirstMethod {

    public static void CoolCopmputer(int a,int b)
    {
        if(a==b)
            System.out.println("Оба компьютера хороши");
        if(a>b)
            System.out.println("Твой компьютер круче");
        if(a<b)
            System.out.println("Твой компьютер хуже");
    }

    public static void DoubleNum(double n)
    {
        System.out.println(n+" -> "+n*2);
    }

    public static int isPrime(int num)
    {
        int counter=1;
        for(int j=2;j<num/2+1;j++)
        {
            if(num%j==0){
                counter++;
                System.out.print(j+" ");
            }
        }
        return counter;
    }

    public static void primeNums(int n)
    {
        int max=0,p=0,maxVal=0;
        for(int i=0;i<n;i++)
        {
            System.out.print(i+": ");
            p=isPrime(i);
            if(p==1)
            {
                System.out.print("Prime");
            }
            if(p>max)
            {
                max=p;
                maxVal=i;
            }
            System.out.println();
        }
        System.out.println("Max dividers: "+max+" to "+maxVal);
    }

    public static void main(String[] args)
    {
        Random rand=new Random();


       // for(int i=0;i<5;i++)
     //   {
     //   DoubleNum(rand.nextDouble()*25);
      //  }
        primeNums(10000);
      //  CoolCopmputer(16,16);
    }
}
