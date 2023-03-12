package 수들의합5_2018;

import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int left = 0;
        int right = 0;
        int ans = 0;
        int sum = left+right;
        while(true)
        {

            if(sum == N)
                ans++;

            if(sum > N)
            {
                sum -= left;
                left++;
            }
            else//sum <= N
            {
                right++;
                sum += right;

                if(right > N)
                    break;
            }
        }

        System.out.println(ans);

    }
}
