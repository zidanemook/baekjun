package N과M12_15666;

import java.io.*;
import java.util.*;

public class Main
{
    static int N,M;

    static int[] inputArr;
    static int[] ansArr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input;
        input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        inputArr = new int[N];
        ansArr = new int[M];

        input = br.readLine().split(" ");
        for(int i = 0; i < N; ++i)
        {
            inputArr[i] =  Integer.parseInt(input[i]);
        }

        Arrays.sort(inputArr);
        search(0, 0);
    }

    public static void search(int depth, int start)
    {
        if(depth == M)
        {
            sb.setLength(0);

            for(int i = 0; i < ansArr.length; ++i)
            {
                if(i != ansArr.length-1)
                {
                    sb.append(ansArr[i] + " ");
                }
                else
                {
                    sb.append(ansArr[i]);
                }
            }

            System.out.println(sb);
            return;
        }

        int last = 0;
        for(int i = start; i < N; ++i)
        {
            if( last != inputArr[i])
            {
                last = inputArr[i];
                ansArr[depth] = inputArr[i];
                search(depth+1, i);
            }
        }
    }
}
