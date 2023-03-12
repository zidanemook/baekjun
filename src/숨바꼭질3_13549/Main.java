package 숨바꼭질3_13549;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);


        bfs(N, K);

    }

    private static void bfs(int N, int K)
    {
        Queue<Integer> que = new LinkedList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        que.add(N);
        map.put(N, 0);
        int[] child = new int[3];

        while(que.isEmpty() == false)
        {
            int cur = que.poll();

            child[0] = cur + 1;
            child[1] = cur - 1;
            child[2] = cur * 2;

            for(int i = 0; i < 3; ++i)
            {
                if(child[i] < 0 || child[i] > 100000)
                    continue;

                if(map.containsKey(child[i]) == true)
                {
                    if(2 == i)
                    {
                        if(map.get(child[i]) <= map.get(cur))
                            continue;
                    }
                    else if(map.get(child[i]) <= (map.get(cur)+1))
                    {
                        continue;
                    }
                }

                que.add(child[i]);


                if(2 == i)
                    map.put(child[i], map.get(cur));
                else
                    map.put(child[i], map.get(cur)+1);

            }

        }

        System.out.println(map.get(K));

    }
}
