package 평범한배낭12865;

import java.io.*;
public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[] w = new int[N+1];
        int[] p = new int[N+1];

        for (int i = 1; i < N+1; i++)
        {
            input = br.readLine().split(" ");
            w[i] = Integer.parseInt(input[0]);
            p[i] = Integer.parseInt(input[1]);
        }

        int[][] dp = new int[N+1][K+1];//가치들 담을 dp

        for (int i = 1; i < N + 1; i++) //행은 물건 인덱스
        {
            for (int j = 1; j < K + 1; j++) //열은 허용 용량
            {
                if(j >= w[i])
                {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] + p[i]);
                }
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        System.out.println(dp[N][K]);
    }
}
