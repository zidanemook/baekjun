package 수찾기1920;

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

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; ++i)
        {
            int temp = Integer.parseInt(input[i]);
            if(true == find(N, temp, arr))
                sb.append("1\n");
            else
                sb.append("0\n");
        }
        System.out.println(sb);
    }

    public static boolean find(int N, int target, int[] arr)
    {
        int left= 0;
        int right = N-1;
        int half = 0;
        while(left <= right)
        {
            half = (left + right)/2;

            if(arr[half] > target)
            {
                right = half-1;
            }
            else if(arr[half] < target)
            {
                left = half+1;
            }
            else if(arr[half] == target){
                return true;
            }
        }

        return false;
    }
}
