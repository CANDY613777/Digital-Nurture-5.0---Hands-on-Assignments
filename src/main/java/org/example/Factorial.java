package org.example;

public class Factorial {

    public long factorial(int n) {

        if(n==0)
            return 1;

        long fact=1;

        for(int i=1;i<=n;i++)
            fact*=i;

        return fact;
    }
}