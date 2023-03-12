package 숫자고르기2668;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] graph = new int[N+1];

        for(int i = 1; i < N+1; ++i)
        {
            graph[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder ans = new StringBuilder();

        int count = 0;
        for(int i = 1; i < N+1; ++i)
        {
            if(bfs(i, graph))
            {
                count++;
                ans.append(i+"\n");
            }

        }

        System.out.println(count);
        System.out.println(ans);
    }

    private static boolean bfs(int start, int[] graph)
    {
        boolean[] visit = new boolean[graph.length];
        Queue<Integer> que = new LinkedList<>();

        que.offer(start);
        visit[start] = true;

        while(que.isEmpty() == false)
        {
            int cur = que.poll();
            int adj = graph[cur];

            if(adj == start)
                return true;

            if(visit[adj] == false)
            {
                visit[adj] = true;
                que.offer(adj);
            }
        }

        return false;
    }
}
