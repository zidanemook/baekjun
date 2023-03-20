package ATM11399;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; ++i)
        {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        int ans = 0;

        for (int i = 0; i < arr.length; ++i)
        {
            int temp = 0;
            for(int j = 0; j <= i; ++j)
            {
                temp += arr[j];
            }
            ans += temp;
        }

        System.out.println(ans);
    }
}
