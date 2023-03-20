package 센서2212;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] sensor = new int[N];

        for (int i = 0; i < N; i++)
        {
            sensor[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(sensor);

        Integer[] diff = new Integer[N-1];

        for (int i = 1; i < N; i++)
        {
            diff[i-1] = sensor[i] - sensor[i-1];
        }

        Arrays.sort(diff);

        int ans = 0;
        for (int i = 0; i < (N - K); i++)
        {
            ans += diff[i];
        }

        System.out.println(ans);
    }
}
