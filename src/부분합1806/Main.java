package 부분합1806;

import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);

        int[] arr = new int[N];
        input = br.readLine().split(" ");
        for(int i = 0; i < N; ++i)
        {
            arr[i] = Integer.parseInt(input[i]);
        }

        int l = 0;
        int r = 0;
        int sum = arr[0];
        int min = Integer.MAX_VALUE;
        while(true)
        {
            if(l <= r && sum >= S)
            {
                min = Math.min(min, r - l + 1);

                sum -= arr[l];
                l++;
            }
            else//sum < S
            {
                r++;
                if(r >= N)
                    break;
                sum += arr[r];
            }
        }
        if(min == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(min);
    }
}
