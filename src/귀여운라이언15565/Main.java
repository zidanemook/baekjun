package 귀여운라이언15565;

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
        int r = 0;
        int ryan = 0;
        if(arr[0] == 1)
            ryan++;
        int min = Integer.MAX_VALUE;
        while(r < N)
        {
            if(ryan < K)
            {
                r++;
                if((r < N) && arr[r] == 1)
                    ryan++;
            }
            else
            {
                if(arr[l] == 1)
                    ryan--;
                l++;
            }

            if(ryan == K)
                min = Math.min(min, r-l + 1);
        }

        if(min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);
    }
}
