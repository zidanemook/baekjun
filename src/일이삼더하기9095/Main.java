package 일이삼더하기9095;

import java.io.*;
public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] arr = new int[T];
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < arr.length; i++) {

            int N = arr[i];
            int[] dp = new int[Math.max(4, N+1)];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for (int j = 4; j <= N; j++)
            {
                for (int k = j-3; k < j; k++)
                {
                    dp[j] += dp[k];
                }
            }

            System.out.println(dp[N]);
        }

    }
}
