package N과M6_15655;

import java.io.*;
import java.util.Arrays;

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
        arr = new int[M];
        checked = new boolean[N];

        input = br.readLine().split(" ");
        for(int i = 0; i < N; ++i)
        {
            inputArr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(inputArr);

        search(0, 0);

        System.out.println(sb);
    }

    static void search(int depth, int start)
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

        for(int i = start; i < N; ++i)
        {
            if(checked[i] == false)
            {
                checked[i] = true;
                arr[depth] = inputArr[i];
                search(depth+1, i);
                checked[i] = false;
            }
        }
    }
}
