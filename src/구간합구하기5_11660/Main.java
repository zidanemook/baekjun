package 구간합구하기5_11660;

import java.io.*;
public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);//1 ≤ N ≤ 1024
        int M = Integer.parseInt(input[1]);//1 ≤ M ≤ 100,000

        int[][] mat = new int[N][N];

        for (int i = 0; i < N; i++)
        {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++)
            {
                mat[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[][] oper = new int[M][4];
        for (int i = 0; i < M; i++)
        {
            input = br.readLine().split(" ");
            for (int j = 0; j < 4; j++)
            {
                oper[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++)
        {
            int rowSum = 0;
            for (int j = 0; j < N; j++)
            {
                rowSum += mat[i][j];
                dp[i][j] = rowSum;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++)
        {
            int row1 = oper[i][0]-1;//0부터 시작 index 로 변경
            int col1 = oper[i][1]-1;
            int row2 = oper[i][2]-1;
            int col2 = oper[i][3]-1;

            int sum = 0;
            for (int j = row1; j <= row2; j++)
            {
                if(col1 > 0)
                    sum += dp[j][col2] - dp[j][col1-1];
                else
                    sum += dp[j][col2];
            }
            sb.append(sum+"\n");
        }

        System.out.println(sb);
    }
}
