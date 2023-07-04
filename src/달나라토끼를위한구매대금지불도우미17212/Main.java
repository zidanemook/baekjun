package 달나라토끼를위한구매대금지불도우미17212;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int money = Integer.parseInt(br.readLine());

        int[] coin = {1, 2, 5, 7};

        int[] dp = new int[100001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 2;
        dp[5] = 1;
        dp[6] = 2;
        dp[7] = 1;

        for (int i = 8; i <= money; i++) {
            dp[i] = Math.min( dp[i-1], Math.min(dp[i-2], Math.min(dp[i-5], dp[i-7])))+1;
        }

        System.out.println(dp[money]);
    }
}
