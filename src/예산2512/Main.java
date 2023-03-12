package 예산2512;

import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        String[] input = br.readLine().split(" ");

        int high = 0;
        int sum = 0;
        for(int i = 0; i < N; ++i)
        {
            arr[i] = Integer.parseInt(input[i]);
            high = Math.max(high, arr[i]);
            sum += arr[i];
        }

        int M = Integer.parseInt(br.readLine());

        if(sum <= M)
        {
            System.out.println(high);
            return;
        }

        int low = 0;


        int money = 0;
        while((high - low) > 1)
        {
            sum = 0;
            money = (high + low) / 2;
            for(int i = 0; i < N; ++i)
            {
                if(arr[i] >= money)
                    sum += money;
                else
                    sum += arr[i];
            }

            if(M < sum)
                high = money;
            else
                low = money;
        }

        System.out.println(low);
    }
}
