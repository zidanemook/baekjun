package 알약4811;

import java.io.*;
import java.util.*;

public class Main {

    static long[][] dp = new long[31][31];
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp[0][0] = 1;
        for (int i = 0; i <= 30; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            System.out.println(dp[n][n]);
        }
    }
}
