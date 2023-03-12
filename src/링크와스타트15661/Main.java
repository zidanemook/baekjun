package 링크와스타트15661;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] stat;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        stat = new int[N][N];

        String[] input;
        for(int i = 0; i < N; ++i)
        {
            input = br.readLine().split(" ");
            for(int j = 0; j < N; ++j)
            {
                stat[i][j] = Integer.parseInt(input[j]);
            }
        }


    }
}
