package 치킨치킨치킨16439;

import java.io.*;

public class Main {

    static int N,M, MAX;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        int[][] inputArr = new int[N][M];

        for(int i = 0; i < N; ++i)
        {
            String[] read = br.readLine().split(" ");
            for(int j = 0; j < M; ++j)
            {
                inputArr[i][j] = Integer.parseInt(read[j]);
            }
        }

        int[] arr = new int[3];
        boolean[] visited = new boolean[M];

        search(0, arr, visited, inputArr);

        System.out.println(MAX);
    }

    public static void search(int level, int[] arr, boolean[] visited, int[][] inputArr)
    {
        if(level == 3)
        {
            int maxOfPerson;
            int sum = 0;
            for(int i = 0; i < N; ++i)
            {
                maxOfPerson = Integer.MIN_VALUE;
                for(int j = 0; j < arr.length; ++j)
                {
                    maxOfPerson = Math.max(maxOfPerson, inputArr[i][arr[j]]);
                }
                sum += maxOfPerson;
            }
            MAX = Math.max(sum, MAX);
            return;
        }

        for(int i = arr[level==0 ? 0 : level-1]; i < M; ++i)
        {
            if(visited[i] == false)
            {
                arr[level] = i;
                visited[i] = true;
                search(level+1, arr, visited, inputArr);
                visited[i] = false;
            }

        }
    }
}
