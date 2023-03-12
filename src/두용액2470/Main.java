package 두용액2470;

import java.io.*;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        String[] input = br.readLine().split(" ");

        for(int i = 0; i < N; ++i)
        {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        int l = 0;
        int r = N-1;
        long sum = arr[l]+arr[r];
        int[] ans = new int[2];
        ans[0] = arr[l];
        ans[1] = arr[r];
        long newSum = 0;
        while(true)
        {
            newSum = arr[l]+arr[r];
            if(Math.abs(sum) > Math.abs(newSum))
            {
                sum = newSum;
                ans[0] = arr[l];
                ans[1] = arr[r];
            }

            if(0 <= newSum)
            {
                r--;
            }
            else //0 > newSum
            {
                l++;
            }

            if(l >= r)
                break;
        }

        System.out.print(ans[0] + " " + ans[1]);
    }
}
