package N과M4_15652;

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] array = new int[M];

        StringBuilder sb = new StringBuilder();
        recurMakeArray(N, M, 0, array, sb);

        System.out.println(sb.toString());
    }
    public static void recurMakeArray(int N, int M, int depth, int[] array, StringBuilder sb)
    {
        if(depth == M)
        {
            for(int i = 0; i < array.length; ++i)
            {
                if(i != array.length-1)
                    sb.append(array[i]+1 + " ");
                else
                    sb.append(array[i]+1 + "\n");
            }
            return;
        }

        for(int i = array[depth==0?0:depth-1]; i < N; ++i)
        {
            array[depth] = i;
            recurMakeArray(N, M, depth+1, array, sb);
        }
    }
}
