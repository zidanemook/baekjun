package 일1로만들기_1463;

import java.io.*;
import java.util.*;
public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N == 1)
        {
            System.out.println(0);
            return;
        }
        if(N == 2 || N == 3)
        {
            System.out.println(1);
            return;
        }


        int[] dp = new int[N+1];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 4; i <= N; i++)
        {
            if(i % 3 == 0)
                pq.add(dp[i/3] + 1);

            if(i % 2 == 0)
                pq.add(dp[i/2] + 1);

            pq.add(dp[i-1]+1);

            dp[i] = pq.poll();
            pq.clear();
        }

        System.out.println(dp[N]);
    }
}
