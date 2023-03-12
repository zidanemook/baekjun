package 수묶기1744;

import java.io.*;
import java.util.*;

public class Main
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException
    {
        int N = Integer.parseInt(br.readLine());

        Integer[] input = new Integer[N];

        for(int i = 0; i < N; ++i)
        {
            input[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(input, Collections.reverseOrder());

        int sum = 0;

        int idx = 0;
        while(idx < N)
        {
            if(idx+1 < N )
            {
                if(input[idx+1] > 0 && input[idx+1] != 1)
                {
                    sum += input[idx] * input[idx+1];
                    idx+=2;
                }
                else if(input[idx] <= 0 && (N - idx) %2 == 0 )
                {
                    sum += input[idx] * input[idx+1];
                    idx+=2;
                }
                else//input[idx] > 0 && input[idx+1] <= 0
                {
                    sum += input[idx];
                    idx++;
                }

            }
            else
            {
                sum += input[idx];
                idx++;
            }

        }

        System.out.println(sum);
    }
}
