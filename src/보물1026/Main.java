package 보물1026;

import java.io.*;
import java.util.*;

public class Main
{
    static BufferedReader br;

    static int N;

    static Integer[] A;
    static Integer[] B;

    public static void main(String[] args) throws IOException
    {
        inputProcess();

        Arrays.sort(A);
        Arrays.sort(B, Comparator.reverseOrder());

        int sum = 0;
        for(int i = 0; i < N; ++i)
        {
            sum += A[i] * B[i];
        }

        System.out.println(sum);
    }

    public static void inputProcess() throws IOException
    {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        A = new Integer[N];
        B = new Integer[N];

        String[] input;
        input = br.readLine().split(" ");
        for(int i = 0; i < N; ++i)
        {
            A[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        for(int i = 0; i < N; ++i)
        {
            B[i] = Integer.parseInt(input[i]);
        }
    }


}
