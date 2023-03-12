package 휴게소세우기1477;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int l = Integer.parseInt(input[2]);

        input = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0; i < n; ++i)
        {
            arr[i] = Integer.parseInt(input[i]);
        }

        int left = 0;
        int right = 1000;
        int cand = 0;//어떤위치 지을것인가
        int ans = 0;

        while(left <= right)
        {
            cand = (left + right)/2;


        }

    }
}
