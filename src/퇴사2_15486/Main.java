package 퇴사2_15486;

import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());//1 ≤ N ≤ 1,500,000

        String[] input;
        int[][] schedule = new int[N+2][2];
        long[] dp = new long[N+2];

        for (int i = 1; i < N+1; i++)
        {
            input = br.readLine().split(" ");

            schedule[i][0] = Integer.parseInt(input[0]);
            schedule[i][1] = Integer.parseInt(input[1]);
        }

        for (int today = N; today >= 1; today--)
        {
            int needD = schedule[today][0];

            if(today+needD-1 > N)
            {
                dp[today] = dp[today+1];
            }
            else
            {
                dp[today] = Math.max(dp[today+1], dp[today+needD]+schedule[today][1]);
            }
        }

        System.out.println(dp[1]);
    }
}
