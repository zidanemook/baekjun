package 수들의합2_2003;

import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] arr = new int[N];
        input = br.readLine().split(" ");
        for(int i = 0; i < N; ++i)
        {
            arr[i] = Integer.parseInt(input[i]);
        }

        int l = 0;
        int r = 0;
        int sum = arr[0];
        int ans = 0;
        while(true)
        {
            if(sum == M)
                ans++;

            if(l!=r && sum > M)
            {
                sum -= arr[l];
                l++;
            }
            else//sum <= M
            {
                r++;
                if(r >= N)
                    break;
                sum += arr[r];
            }
        }

        System.out.println(ans);
    }
}
