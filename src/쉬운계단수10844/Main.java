package 쉬운계단수10844;

import java.io.*;
public class Main
{
    static final int devide = 1000000000;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[101][10];

        for (int i = 1; i < 10; i++)
        {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                if(j == 0)
                    dp[i][j] = dp[i-1][j+1] % devide;
                if(j >= 1 && j <= 8)
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])% devide;
                if(j == 9)
                    dp[i][j] = dp[i-1][j-1]% devide;
            }
        }

        long ans = 0;
        for(int i = 0; i < 10; i++)
        {
            ans += dp[N][i];
        }

        ans = ans % devide;

        System.out.println(ans);
    }
}
