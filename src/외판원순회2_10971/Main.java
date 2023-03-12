package 외판원순회2_10971;

import java.io.*;
import java.util.*;

public class Main
{

    static int N;
    static int[][] cities;

    static int[] arr;
    static boolean[] checked;

    static int ans = Integer.MAX_VALUE;

    static BufferedReader br;

    public static void main(String[] args) throws IOException
    {
        inputProcess();

        search(0);

        System.out.println(ans);
    }

    public static void inputProcess() throws IOException
    {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cities = new int[N][N];

        arr = new int[N];
        checked = new boolean[N];

        String[] input;
        for(int i = 0; i < N; ++i)
        {
            input = br.readLine().split(" ");
            for(int j = 0; j < N; ++j)
            {
                cities[i][j] = Integer.parseInt(input[j]);
            }
        }
    }

    //같은 숫자 X
    //동일 원소 조합 O
    public static void search(int depth)
    {
        if(depth == N)
        {
            int sum = 0;
            for(int i = 0; i < arr.length; ++i)
            {
                if(i+1 < N)
                {
                    if(cities[arr[i]][arr[i+1]] == 0)//갈 수 없는 경로 있는 경우는 버린다
                    {
                        return;
                    }

                    sum += cities[arr[i]][arr[i+1]];
                }
                else
                {
                    if(cities[arr[i]][arr[0]] == 0)//갈 수 없는 경로 있는 경우는 버린다
                    {
                        return;
                    }

                    sum += cities[arr[i]][arr[0]];
                }

            }

            ans = Math.min(ans, sum);
            return;
        }

        for(int i = 0; i < N; ++i)
        {
            if(false == checked[i])
            {
                checked[i] = true;

                arr[depth] = i;
                search(depth+1);
                checked[i] = false;
            }
        }
    }
}
