package 수열2559;

import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[] arr = new int[N];
        input = br.readLine().split(" ");
        for(int i = 0; i < N; ++i)
        {
            arr[i] = Integer.parseInt(input[i]);
        }

        int l = 0;
        int r = K-1;
        int sum = 0;
        for(int i = l; i <= r; ++i)
            sum += arr[i];
        int max = sum;

        while(true)
        {
            sum -= arr[l];
            l++;
            r++;
            if(r >= N)
                break;
            sum += arr[r];

            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
