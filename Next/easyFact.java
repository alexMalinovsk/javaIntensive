package Next;

public class easyFact {
    public static int fact(int n)
    {
        if(n>1)
            return fact(n-1)*n;
        else
            return 1;
    }

    public static int fib(int n)
    {
        if(n==1)
            return 1;
        if(n==2)
            return 1;
        return fib(n-1)+fib(n-2);
    }

    public static double recPow(double n)
    {
        if(n>1)
            return Math.pow(n,n)+recPow(n-1);
        else
            return 1;
    }

    public static int AkkermanFun(int m,int n)
    {
        if(m==0)
            return n+1;
        if(m>0 && n==0)
            return AkkermanFun(m-1,1);
        if(m>0 && n>0)
            return AkkermanFun(m-1,AkkermanFun(m,n-1));
        return 0;
    }

    public static void main(String[] args)
    {
     //   System.out.println(fact(6));
        //System.out.println(recPow(7));
        System.out.println(AkkermanFun(4,1));
    }
}
