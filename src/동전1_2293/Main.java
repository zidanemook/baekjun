package 동전1_2293;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] fsd) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int coin;
        int[] dp = new int[10001];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {

            coin = Integer.parseInt(br.readLine());
            for (int j = coin; j <= k; j++) {
                dp[j] += dp[j-coin];
            }
        }

        System.out.println(dp[k]);

    }
}
