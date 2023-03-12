package 소수의연속합1644;

import java.io.*;
import java.util.*;

public class Main {

    public static List<Integer> sieveOfEratosthenes(int n) {
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (primes[i]) {
                for (int j = i*i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }
        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                primeList.add(i);
            }
        }
        return primeList;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> primes = sieveOfEratosthenes(n);

        int count = 0, start = 0, end = 0, sumPrime = 0;
        while (end < primes.size()) {
            if (sumPrime < n) {
                sumPrime += primes.get(end);
                end++;
            } else {
                if (sumPrime == n) {
                    count++;
                }
                sumPrime -= primes.get(start);
                start++;
            }
        }
        System.out.println(count);
    }
}


//public class Main
//{
//    public static void main(String[] args) throws IOException
//    {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//
//        if(N < 2)
//        {
//            System.out.println(0);
//            return;
//        }
//
//        ArrayList<Integer> arrList = new ArrayList<>();
//
//        for(int i = 2; i <= N; ++i)
//        {
//            if(isPrime(i))
//                arrList.add(i);
//        }
//
//        int l = 0;
//        int r = 0;
//        int sum = arrList.get(0);
//        int ans = 0;
//        while(true)
//        {
//            if(sum == N)
//                ans++;
//
//            if(sum > N)
//            {
//                sum -= arrList.get(l);
//                l++;
//            }
//            else//sum <= N
//            {
//                r++;
//                if(r >= arrList.size())
//                    break;
//                sum += arrList.get(r);
//            }
//        }
//
//        System.out.println(ans);
//    }
//
//    public static boolean isPrime(int n)
//    {
//        if(n < 2)
//            return false;
//
//        for(int i = 2; i <= Math.sqrt(n); ++i)
//        {
//            if(n % i == 0)
//            {
//                return false;
//            }
//        }
//
//        return true;
//    }
//}
