package 일이삼더하기_16195;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        long[][] dp = new long[1001][1001];

        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 2;
        dp[3][3] = 1;

        for (int i = 4; i < 1001; i++) {
            for (int j = 2; j <= i; j++) {
                dp[i][j] = (dp[i-3][j-1] + dp[i-2][j-1] + dp[i-1][j-1]) % 1000000009;
            }

        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        String[] input;

        int n = 0;//0~1000
        int m = 0;// n <=
        long answer = 0;
        for (int i = 0; i < T; i++) {
            input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);

            for (int j = 0; j <= m; j++) {
                answer = (answer + dp[n][j]) % 1000000009;
            }
            System.out.println(answer);
            answer = 0;

        }

    }
}
