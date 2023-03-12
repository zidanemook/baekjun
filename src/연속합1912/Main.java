package 연속합1912;

import java.io.*;


public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        String[] input = br.readLine().split(" ");

        for(int i = 0; i < n; ++i)
        {
            arr[i] = Integer.parseInt(input[i]);
        }

        int l = 0;
        int r = 0;

        int sum = arr[0];
        int ans = sum;
        while(true)
        {
            if(sum >= 0)
            {
                r++;
                if(r >= n)
                    break;
                sum += arr[r];
            }
            else
            {
                l = r;
                l++;
                r++;
                if(r >= n)
                    break;
                sum = arr[r];
            }


            ans = Math.max(ans, sum);
        }

        System.out.println(ans);
    }
}
