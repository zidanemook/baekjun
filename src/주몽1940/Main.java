package 주몽1940;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        int[] arr = new int[N];
        for(int i = 0; i < N; ++i)
        {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        int l = 0;
        int r = arr.length-1;
        int sum = 0;
        int ans = 0;
        while(l < r)
        {
            sum = arr[l] + arr[r];
            if(sum > M)
            {
                r--;
            }
            else if(sum < M)
            {
                l++;
            }
            else
            {
                l++;
                r--;
                ans++;
            }
        }

        System.out.println(ans);
    }
}
