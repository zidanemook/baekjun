package FourSquares17626;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static double ncopy;
    static ArrayList<Integer> answer;
    static int change;
    static final int maxsqrt = 4;

    static int[] dp = new int[50001];

    public static void main(String[] args) throws  IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int min = Integer.MAX_VALUE;

        int count = 0;//testcode

        for(int i = 0; i < dp.length; ++i)
        {
            dp[i] = 4;
            count++;//testcode
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        int squareNumber;
        for(int i = 4; i <= n; ++i)
        {
            min = Integer.MAX_VALUE;
            squareNumber = (int)Math.sqrt(i);
            for(int j = 1; j <= squareNumber; ++j)
            {
                min = dp[i-j*j]+1;
                dp[i] = Math.min(dp[i], min);
                count++;//testcode
            }

        }

        System.out.println(dp[n]);
        System.out.println(count);
    }

}
