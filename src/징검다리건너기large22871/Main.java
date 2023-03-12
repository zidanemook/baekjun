package 징검다리건너기large22871;

import java.io.*;
import java.util.*;

public class Main
{
    static int N;
    static int[] arr;
    static long max = Integer.MIN_VALUE;

    static long left = 0;
    static long right = 0;
    static long K = 0;
    static long ans = Integer.MAX_VALUE;

    static Stack<Integer> stack = new Stack<>();


    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; ++i)
        {
            arr[i] = Integer.parseInt(input[i]);
        }

        right = 5000*1000000;

        while(left <= right)
        {
            K = (left + right) / 2;

            boolean go = false;
            stack.add(0);
            while(stack.isEmpty() == false)
            {
                int cur = stack.pop();

                if(cur == N-1)
                {
                    go = true;
                    break;
                }

                for(int i = cur+1; i < N; ++i)
                {
                    if(K < (i-cur)*(1+Math.abs(arr[cur]-arr[i])))
                    {
                    }
                    else
                    {
                        stack.add(i);
                        break;
                    }
                }
            }

            if(go)
            {
                ans = K;
                right = K - 1;
            }
            else
            {
                left = K+1;
            }

        }

        System.out.println(ans);

    }

}
