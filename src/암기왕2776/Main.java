package 암기왕2776;

import java.io.*;
import java.util.*;

public class Main
{
    static BufferedReader br;

    static int T;
    static int N;

    static int M;

    static Set<Integer> set = new HashSet();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException
    {
        br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        String[] input;
        for(int i = 0; i < T; ++i)
        {
            N = Integer.parseInt(br.readLine());
            input = br.readLine().split(" ");
            for(int j = 0; j < N; ++j)
            {
                set.add(Integer.parseInt(input[j]));
            }

            M = Integer.parseInt(br.readLine());
            input = br.readLine().split(" ");
            for(int j = 0; j < M; ++j)
            {
                if(set.contains(Integer.parseInt(input[j])))
                    sb.append(1);
                else
                    sb.append(0);
                sb.append("\n");
            }
            set.clear();
        }

        System.out.println(sb);
    }
}
