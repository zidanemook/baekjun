package RGB거리1149;

import java.io.*;
public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] input;

        int[][] dp = new int[N][3];
        input = br.readLine().split(" ");
        for (int i = 0; i < 3; i++) {

            dp[0][i] = Integer.parseInt(input[i]);
        }

        for (int i = 1; i < N; i++)
        {
            input = br.readLine().split(" ");

            int R = Integer.parseInt(input[0]);
            int G = Integer.parseInt(input[1]);
            int B = Integer.parseInt(input[2]);

            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + R;
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + G;
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + B;
        }

        System.out.println(Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]));
    }
}
