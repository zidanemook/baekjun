package 동전0_11047;

import java.io.*;
public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);

        int K = Integer.parseInt(input[1]);

        int[] coin = new int[N];

        for(int i = 0; i < N; ++i)
        {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int copy = K;
        int idx = N-1;
        int ans = 0;
        while(copy > 0 && idx >= 0)
        {
            int temp = copy / coin[idx];
            if(temp > 0)
            {
                ans += temp;
                copy %= coin[idx];
            }
            else {
                idx--;
            }
        }

        System.out.println(ans);
    }
}
