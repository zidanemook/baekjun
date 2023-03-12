package 좋다1253;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i = 0; i < N; ++i)
        {
            arr[i] = Integer.parseInt(input[i]);
        }

        if(N < 3)
        {
            System.out.println(0);
            return;
        }

        Arrays.sort(arr);

        int ans = 0;
        for(int i = 0; i < N; ++i)
        {
            int l = 0;
            if(l == i)//자기자신 제외하고 더하기
                l++;
            int r = N-1;
            if(r == i)//자기 자신 제외하고 더하기
                r--;
            int sum = 0;
            while(l < r)
            {
                sum = arr[l]+arr[r];

                if(sum == arr[i])
                {
                    ans++;
                    break;
                }

                if(sum > arr[i])
                {
                    r--;
                    if(r == i)
                        r--;
                }
                else
                {
                    l++;
                    if(l == i)
                        l++;
                }

            }
        }
        System.out.println(ans);
    }
}
