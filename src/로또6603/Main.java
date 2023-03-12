package 로또6603;

import java.io.*;

public class Main
{
    static BufferedReader br;
    static int K;
    static int[] S;

    static boolean[] check;
    static final int LOTTO_LEN = 6;
    static int[] arr = new int[LOTTO_LEN];

    static int count = 0; //testcode
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException
    {
        br = new BufferedReader(new InputStreamReader(System.in));

        String[] input;

        while(true)
        {
            input = br.readLine().split(" ");
            if(Integer.parseInt(input[0]) == 0)
                break;

            K = Integer.parseInt(input[0]);
            S = new int[K];
            check = new boolean[K];

            for(int i = 0; i < K; ++i)
            {
                S[i] = Integer.parseInt(input[i+1]);
            }

            search(0, 0);
            sb.append("\n");
        }

        System.out.println(sb);
        System.out.println(count);//testcode
    }

    public static void search(int depth, int start)
    {
        if(depth == LOTTO_LEN)
        {
            count++;
            for(int i = 0; i < LOTTO_LEN; ++i)
            {
                if(i != LOTTO_LEN-1)
                    sb.append(arr[i] + " ");
                else
                    sb.append(arr[i] + "\n");
            }
            return;
        }

        for(int i = start; i < K; ++i)
        {
            if(false == check[i])
            {
                check[i] = true;
                arr[depth] = S[i];
                search(depth+1, i);
                check[i] = false;
            }

        }
    }
}
