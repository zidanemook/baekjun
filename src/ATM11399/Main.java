package ATM11399;

import java.io.*;
import java.util.*;

public class Main
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] P;

    public static void main(String[] args) throws IOException
    {
        N = Integer.parseInt(br.readLine());
        P = new int[N];

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; ++i)
        {
            P[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(P);

        int sum = P[0];
        for(int i = 1; i < N; ++i)
        {
            P[i] = P[i-1] + P[i];
            sum += P[i];
        }

        System.out.println(sum);
    }
}
