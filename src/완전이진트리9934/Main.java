package 완전이진트리9934;

import java.io.*;
import java.util.*;

public class Main
{
    static int[] arr;
    static int N;
    static int K;

    static ArrayList<ArrayList<Integer>> ans;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        N = (int)Math.pow(2, K) - 1;

        String[] input = br.readLine().split(" ");

        arr = new int[N];
        for(int i = 0; i < N; ++i)
        {
            arr[i] = Integer.parseInt(input[i]);
        }

        ans = new ArrayList<>();
        for(int i = 0; i < K+1; ++i)
            ans.add(new ArrayList<>());

        search(1, 0, N-1);

        for(int i = 1; i < ans.size(); ++i)
        {
            ArrayList<Integer> arrLevel = ans.get(i);
            for(int j = 0; j < arrLevel.size(); ++j)
            {
                if(j == arrLevel.size()-1)
                    System.out.print(arrLevel.get(j));
                else
                    System.out.print(arrLevel.get(j) + " ");
            }

            System.out.println();
        }

    }

    public static void search(int level, int l, int r)
    {
        if(level > K)
            return;

        int pivot = l+ ((r-l) / 2);

        ans.get(level).add(arr[pivot]);

        search(level+1, l, pivot-1);
        search(level+1, pivot+1, r);
    }
}
