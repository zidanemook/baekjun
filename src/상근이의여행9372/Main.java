package 상근이의여행9372;

import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        String[] input;
        for(int i = 0; i < T; ++i)
        {
            input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            System.out.println(N-1);

            for(int j = 0; j < M; ++j)
            {
               input = br.readLine().split(" ");
            }
        }
    }
}
