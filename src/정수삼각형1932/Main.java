package 정수삼각형1932;

import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int size = (int)Math.pow(2, N) -1;

        int[][] tri = new int[N][];

        String[] input;
        for (int i = 0; i < N; i++)
        {
            tri[i] = new int[i+1];
            input = br.readLine().split(" ");
            for (int j = 0; j < i+1; j++)
            {
                tri[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[][] dp = new int[N][];
        for (int i = 0; i < N; i++)
        {
            dp[i] = new int[tri[i].length];
        }

        dp[0][0] = tri[0][0];

        for (int i = 1; i < N; i++)
        {
            for (int j = 0; j < dp[i].length; j++)
            {
                if(j == 0)
                    dp[i][j] = tri[i][j] + dp[i-1][j];
                else if(j == dp[i].length-1)
                    dp[i][j] = tri[i][j] + dp[i-1][j-1];
                else
                    dp[i][j] = tri[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++)
        {
            ans = Math.max(ans, dp[N-1][i]);
        }

        System.out.println(ans);
    }
}
