package 입국심사3079;

import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N,M;//심사대개수, 사람수
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        int[] arr = new int[N];

        long high = 0;
        for(int i = 0; i < N; ++i)
        {
            arr[i] = Integer.parseInt(br.readLine());
            high = Math.max(high, arr[i]);
        }

        high *= M;
        long low = 0;
        long can = 0;
        long sum = 0;
        while((high-low) > 1)
        {
            can = (high + low) / 2;

            sum = 0;
            for(int i = 0; i < N; ++i)
            {
                sum += can /arr[i];
            }

            if(sum >= M)
            {
                high = can;
            }
            else if(sum < M)
            {
                low = can;
            }
        }

        System.out.println(high);
    }
}
