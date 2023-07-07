package 공약수2436;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);//최대공약수 2 ~ 1억
        int B = Integer.parseInt(input[1]);//최소공배수 2 ~ 1억

        int num = 1;
        long na = 0;
        long nb = 1;

        long minSum = Integer.MAX_VALUE;
        long mina = 0;
        long minb = 0;

        while(na<nb) {

            na = A*num;
            nb = B/num;

            if(A != gcd(na, nb)){
                num++;
                continue;
            }


            if(B != lcm(na, nb, A)){
                num++;
                continue;
            }


            if(minSum > (na+nb)){
                minSum = na+nb;
                mina = na;
                minb = nb;
            }

            num++;
        }

        System.out.println(mina + " " + minb);
    }

    public static long gcd(long a, long b){
        long min = Math.min(a,b);
        long max = Math.max(a,b);

        if(max%min == 0){
            return min;
        }else{
            return gcd(min, max%min);
        }
    }

    public static long lcm(long a, long b, int gcd){
        return (a*b)/gcd;
    }
}
