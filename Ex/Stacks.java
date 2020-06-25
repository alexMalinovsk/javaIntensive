package Ex;

import java.util.Scanner;
import java.util.Stack;

public class Stacks {
    public static void main(String[] args) {
        Stack<Character> arr=new Stack<>();
        char buf=' ';
        Scanner sc=new Scanner(System.in);
        while(buf!='0')
        {
            buf=sc.nextLine().charAt(0);

            if(arr.empty() && buf=='0') {
                System.out.println("Yes");
                break;
            }

            if(buf=='0' && !arr.empty())
            {
                System.out.println("No");
                break;
            }

            if(buf=='(' || buf=='[' || buf=='{') {
                arr.push(buf);
                continue;
            }

            if(!arr.empty())
            {
                if((buf==')' && arr.peek()=='(') || (buf=='}' && arr.peek()=='{') || (buf==']' && arr.peek()=='['))
                    arr.pop();
                else
                {
                    System.out.println("No");
                    break;
                }
            }
            else
            {
                System.out.println("No");
                break;
            }

        }
    }
}