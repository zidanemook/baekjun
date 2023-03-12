package 랜선자르기1654;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int k = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        int[] arr = new int[k];

        for(int i = 0; i < k; ++i)
        {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long right = Integer.MAX_VALUE;
        long left = 0;
        long cand = 0;
        long ans = 0;

        while(left <= right)
        {
            cand = (left + right) / 2;

            if(n <= cal(cand, arr))
            {
                ans = cand;
                left = cand + 1;
            }
            else
            {
                right = cand - 1;
            }
        }

        System.out.println(ans);
    }

    public static long cal(long cand, int[] arr)
    {
        if(cand == 0)
            cand = 1;

        long ret = 0;
        for(int element : arr)
        {
            if(element >= cand)
                ret += element / cand;
        }

        return ret;
    }
}
