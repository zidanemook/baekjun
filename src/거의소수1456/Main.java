package 거의소수1456;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        long A = Long.parseLong(input[0]);
        long B = Long.parseLong(input[1]);

        int len = (int)Math.sqrt(B);

        boolean[] primes = new boolean[len+1];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;

        for (int i = 2; i * i <= len; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= len; j += i) {
                    primes[j] = false;
                }
            }
        }

        int answer = 0;
        for (int i = 2; i <= len; i++) {
            if(primes[i]){
                int mul = 2;
                long next = (long)Math.pow(i, mul);
                while(next <= B){
                    if(next >= A){
                        answer++;
                    }
                    mul++;
                    next = (long)Math.pow(i, mul);
                }
            }
        }

        System.out.println(answer);
    }
    public static boolean isPrime(long num){
        if(num == 0 || num == 1)
            return false;

        for(long i = 2; i <= Math.sqrt(num); ++i){
            if(0 == num%i){
                return false;
            }
        }

        return true;
    }
}
