package 먹을것인가먹힐것인가7795;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int N,M;
        String[] input;
        Integer[] A,B;
        int ans;
        for(int i = 0; i < T; ++i)
        {
            ans = 0;
            input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);

            A = new Integer[N];
            B = new Integer[M];

            input = br.readLine().split(" ");
            for(int j = 0; j < N; ++j)
            {
                A[j] = Integer.parseInt(input[j]);
            }

            input = br.readLine().split(" ");
            for(int j = 0; j < M; ++j)
            {
                B[j] = Integer.parseInt(input[j]);
            }

            Arrays.sort(A, Collections.reverseOrder());
            Arrays.sort(B, Collections.reverseOrder());

            for(int j = 0; j < A.length; ++j)
            {
                for(int k = 0; k < B.length; ++k)
                {
                    if(A[j] > B[k])
                    {
                        ans+=B.length-k;
                        break;
                    }
                }
            }

            System.out.println(ans);
        }
    }
}
