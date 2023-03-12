package 로마숫자만들기;

import java.io.*;
import java.util.*;

public class Main
{
    static BufferedReader br;
    static int N;

    static int[] arr;

    static int[] num = {1, 5, 10, 50};

    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException
    {
        inputProcess();

        search(0, 0);

        System.out.println(set.size());
    }

    public static void inputProcess() throws IOException
    {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
    }

    public static void search(int depth, int start)
    {
        if(depth == N)
        {

            int sum = 0;
            for(int i = 0; i < depth; ++i)
            {
                sum += arr[i];
            }

            set.add(sum);

            return;
        }

        for(int i = start; i < num.length; ++i)
        {
            arr[depth] = num[i];
            search(depth+1, i);
        }
    }
}
