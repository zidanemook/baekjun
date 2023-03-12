package 부분수열의합1182;

import java.io.*;

public class Main {

    static int[] inputArr;
    static int[] arr;
    static boolean[] checked;
    static int N;
    static int S;

    static int ans;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);

        inputArr = new int[N];
        checked = new boolean[N];
        arr = new int[N];

        input = br.readLine().split(" ");
        for(int i = 0; i < N; ++i)
        {
            inputArr[i] = Integer.parseInt(input[i]);
        }

        dfs(0, 1, 0);

        System.out.println(ans);

    }

    public static void dfs(int depth, int targetdepth, int start)
    {
        if(depth == targetdepth)
        {
            int sum = 0;

            for(int i =0; i < depth; ++i)
            {
                sum += arr[i];
            }

            if(S == sum)
                ans++;

            //testcode
            //for(int i = 0; i < depth; ++i)
            //{
            //    System.out.print((arr[i])+" ");
            //}
            //System.out.println();
            //

            return;
        }

        for(int i = start; i < N; ++i)
        {
            if(checked[i] == false)
            {
                checked[i] = true;
                arr[depth] = inputArr[i];
                dfs(depth+1, targetdepth, i);
                dfs(depth+1, targetdepth+1, i);
                checked[i] = false;
            }
        }
    }
}

