package 가장큰정사각형1915;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] dp = new int[n+1][m+1];
        int[][] dir = { {0, -1}, {-1, -1}, {-1, 0}};

        int answer = 0;
        for (int i = 1; i <= n; i++) {

            input = br.readLine().split("");
            for (int j = 1; j <= m; j++) {

                dp[i][j] = Integer.parseInt(input[j-1]);

                if(dp[i][j] == 0)
                    continue;

                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    int r = i + dir[k][0];
                    int c = j + dir[k][1];

                    min = Math.min(min, dp[r][c]);

                }

                dp[i][j] = min+1;
                answer = Math.max(answer, dp[i][j]);
            }
        }

        System.out.println(answer*answer);
    }
}
