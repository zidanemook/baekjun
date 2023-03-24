package 가장긴증가하는부분수열11053;

import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
        {
            arr[i] = Integer.parseInt(input[i]);
        }

        int[] dp = new int[N];
        dp[0] = 1;

        for (int i = 1; i < N; i++)
        {
            int max = 0;
            for (int j = 0; j < i; j++)
            {
                if(arr[j] < arr[i])
                    max = Math.max(max, dp[j]);
            }
            dp[i] = max + 1;
        }

        int max = 0;
        for (int i = 0; i < N; i++)
        {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
