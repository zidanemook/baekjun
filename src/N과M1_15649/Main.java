package N과M1_15649;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] array = new int[M];

        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[N];
        recurMakeArray(N, M, 0, array, sb, visited);

        System.out.println(sb.toString());
    }
    public static void recurMakeArray(int N, int M, int depth, int[] array, StringBuilder sb, boolean[] visited)
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

        for(int i = 0; i < N; ++i)
        {
            if(visited[i] == false)
            {
                visited[i] = true;
                array[depth] = i;
                recurMakeArray(N, M, depth+1, array, sb, visited);
                visited[i] = false;
            }

        }
    }
}
