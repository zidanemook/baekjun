package 소수팰린드롬1747;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int inum = Integer.parseInt(input);

        int max = 1100000;


        for(int i = inum; i < max; ++i){
            if(isPal(i) && isPrime(i)){
                System.out.println(i);
                break;
            }
        }

    }

    public static boolean isPal(int num){
        int numcopy = num;
        int len = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        while(numcopy != 0){
            arr.add(numcopy%10);
            numcopy /= 10;
            len++;
        }

        for(int i = 0; i < len/2; ++i){
            if(arr.get(i) != arr.get(len-1-i))
                return false;
        }

        return true;
    }

    public static boolean isPrime(int num){
        if(num == 0 || num == 1)
            return false;

        int size = (int)Math.sqrt(num);

        for(int i = 2; i <= size; ++i){
            if(num % i == 0)
                return false;
        }

        return true;
    }
}
