package N과M10_15664;

import java.io.*;
import java.util.*;

public class Main
{

    static int N;
    static int M;
    static int[] arrNum;

    static int[] inputNum;
    static boolean[] checked;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input;
        input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arrNum = new int[M];
        inputNum = new int[N];
        checked = new boolean[N];

        input = br.readLine().split(" ");
        for(int i = 0; i < N; ++i)
        {
            inputNum[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(inputNum);
        search(0, 0);
    }

    public static void search(int depth, int start)
    {
        if(depth == M)
        {
            sb.setLength(0);
            for(int i = 0; i < arrNum.length; ++i)
            {
                if(i != arrNum.length-1)
                    sb.append(arrNum[i] + " ");
                else
                    sb.append(arrNum[i]);
            }

            System.out.println(sb);

            return;
        }

        int last = -1;
        for(int i = start; i < N; ++i)
        {
            if(checked[i] == false && last != inputNum[i])
            {
                last = inputNum[i];
                checked[i] = true;
                arrNum[depth] = inputNum[i];
                search(depth+1, i);
                checked[i] = false;
            }

        }
    }
}
