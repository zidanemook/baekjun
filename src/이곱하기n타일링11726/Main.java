package 이곱하기n타일링11726;

/**
 * 2×n 타일링
 */

import java.io.*;
public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());//1 ≤ n ≤ 1,000

        long[] dp = new long[Math.max(n+1, 3)];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++)
        {
            dp[i] = (dp[i-2]+dp[i-1])% 10007L;
        }

        System.out.println(dp[n]);
    }
}
