package democodes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivideEx 
{
    public static class InvalidAgeException extends Exception{
        public InvalidAgeException(String msg)
        {
            super(msg);
        }
    }

    public static class LimitExceedException extends Exception{
        public LimitExceedException(String msg)
        {
            super(msg);
        }
    }

    public static void main(String args[])
    {
        System.out.println("Enter 2 numbers for division");
        try{

            Scanner sc= new Scanner(System.in);
            System.out.println("Enter numerator");
            int a =sc.nextInt();
            System.out.println("Enter denominator");
            int b= sc.nextInt();

            int div=a/b;

            System.out.println("Division is "+div);

        }
        catch(ArithmeticException | InputMismatchException  e)
        {
            System.out.print("Exception "+e);
        }
        catch(Exception p)
        {
            System.out.println("Exception Occured "+p);
        }

        try{
            Scanner sc= new Scanner(System.in);
            System.out.println("Enter age");
            int age = sc.nextInt();
            if(age<18)
            {
                throw new InvalidAgeException("Age cannot be less than 18");
            }
            else{
                System.out.println("You are eligible");
            }
        }
        catch(InvalidAgeException q){
            System.out.println(q);

        }
        try{
            for(int i=0;i<100;i++)
            {
                System.out.println("values of i "+i);
                if(i>10)
                {
                    throw new LimitExceedException("Allow only 10 users ");
                }
            }
        }
        catch(LimitExceedException l)
        {
            System.out.println("exception "+l);
        }
        finally{
            System.out.println("Code execution completed");
        }

    }
}