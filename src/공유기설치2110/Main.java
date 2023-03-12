package 공유기설치2110;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        int[] arr = new int[n];
        for(int i = 0; i < n; ++i)
        {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = 1000000000;
        int cand = 0;
        int ans = 0;
        while(left <= right)
        {
            cand = (left+right)/2;
            if(cal(arr, cand) >= c)
            {
                ans = Math.max(ans, cand);
                left = cand+1;
            }
            else
            {
                right = cand-1;
            }

        }

        System.out.println(ans);

    }
    public static int cal(int[] arr, int cand)
    {
        int ret = 1;

        int start = 0;
        for(int i = 0; i+1 < arr.length; ++i)
        {
            if((arr[i+1] - arr[start]) >= cand)
            {
                start = i+1;
                ret++;
            }
        }

        return ret;
    }
}
