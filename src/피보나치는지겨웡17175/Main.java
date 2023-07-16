package 피보나치는지겨웡17175;

import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[51];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < 51; i++) {
            dp[i] = (dp[i-1] + dp[i-2] + 1) % 1000000007;
        }

        System.out.println(dp[n]);
    }

}
