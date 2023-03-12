package N과M9_15663;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;

    static int[] inputArr;
    static int[] arr;

    static boolean[] checked;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input;
        input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        inputArr = new int[N];
        checked = new boolean[N];
        arr = new int[M];

        input = br.readLine().split(" ");
        for(int i = 0; i < N; ++i)
        {
            inputArr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(inputArr);

        search(0);

        System.out.println(sb);
    }

    static void search(int depth)
    {
        if(depth == M)
        {
            for(int i = 0; i < arr.length; ++i)
            {
                if(i != arr.length-1)
                    sb.append((arr[i]) + " ");
                else
                    sb.append((arr[i]) + "\n");
            }
            return;
        }

        int last = 0;
        for(int i = 0; i < N; ++i)
        {
            if(checked[i] == false && inputArr[i] != last)
            {
                checked[i] = true;
                arr[depth] = inputArr[i];
                last = inputArr[i];
                search(depth+1);
                checked[i] = false;
            }

        }
    }
}
