package 동전2_2294;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] dp = new int[k+1];

        Integer[] coin = new Integer[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

       //Arrays.sort(coin);
        //Collections.reverse(Arrays.asList(coin));

        for (int i = 0; i < k+1; i++) {
            dp[i] = k+1;
        }
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j-coin[i]]+1);
            }
        }

        if(dp[k] == k+1)
            System.out.println(-1);
        else
            System.out.println(dp[k]);
    }
}
