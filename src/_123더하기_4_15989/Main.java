package _123더하기_4_15989;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] dp = new int[10001];

        //1 로 가능한 경우는 1
        for (int i = 0; i < 10001; i++) {
            dp[i] = 1;
        }

        for (int i = 2; i < 10001; i++) {
            if(i-2 >= 0)
                dp[i] += dp[i-2];
        }

        for (int i = 3; i < 10001; i++) {
            if(i-3 >= 0)
                dp[i] += dp[i-3];
        }

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            System.out.println(dp[n]);
        }
    }
}
