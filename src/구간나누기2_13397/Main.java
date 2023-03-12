package 구간나누기2_13397;

import java.io.*;

public class Main
{
    static int N;
    static int M;

    public static void main(String[] args)throws  IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        int[] arr = new int[N];

        input = br.readLine().split(" ");
        int right = Integer.MIN_VALUE;
        for(int i = 0; i < N; ++i)
        {
            arr[i] = Integer.parseInt(input[i]);
            right = Math.max(right, arr[i]);
        }

        int left = 0;

        int candidate = 0;

        while(left < right)
        {
            candidate = (left + right) / 2;

            int diff;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int cnt = 1;
            for(int i = 0; i < N; ++i)
            {
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);
                diff = max-min;

                if(diff > candidate)
                {
                    cnt++;
                    min = arr[i];
                    max = arr[i];
                }
            }

            if(cnt > M )
            {
                left = candidate+1;
            }
            else if(cnt <= M)
            {
                right = candidate;
            }
        }

        System.out.println(right);
    }
}
