package 일1로만들기2_12852;

import java.io.*;
public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        int[] prev = new int[N+1];

        for (int i = 2; i < N+1; i++)
        {
            dp[i] = dp[i-1]+1;
            prev[i] = i-1;

            if(i%3==0 && (dp[i/3]+1) < dp[i])
            {
                dp[i] = dp[i/3]+1;
                prev[i] = i/3;
            }


            if(i%2==0 && (dp[i/2]+1) < dp[i])
            {
                dp[i] = dp[i/2]+1;
                prev[i] = i/2;
            }

        }

        System.out.println(dp[N]);

        int idx = N;

        while(true)
        {
            if(idx != 1)
                System.out.print(idx + " ");
            else
            {
                System.out.println(idx);
                break;
            }

            idx = prev[idx];

        }
    }
}
