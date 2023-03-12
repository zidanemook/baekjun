package N과M2_15650;

import java.io.*;

public class Main {

    static int N;
    static int M;

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

        arr = new int[M];
        checked = new boolean[N];

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
                    sb.append((arr[i]+1) + " ");
                else
                    sb.append((arr[i]+1) + "\n");
            }
            return;
        }

        for(int i = arr[depth==0?depth:depth-1]; i < N; ++i)
        {
            if(checked[i] == false)
            {
                checked[i] = true;
                arr[depth] = i;
                search(depth+1);
                checked[i] = false;
            }
        }
    }
}
