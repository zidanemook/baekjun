package 연결요소의개수11724;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < N+1; ++i)
            graph.add(new ArrayList<>());

        for(int i = 0; i < M; ++i)
        {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int ans = 0;
        boolean[] visit = new boolean[N+1];
        for(int i = 1; i < N+1; ++i)
        {
            if(visit[i] == false)
            {
                bfs(i, graph, visit);
                ans++;
            }
        }

        System.out.println(ans);
    }

    private static void bfs(int start, ArrayList<ArrayList<Integer>> graph, boolean[] visit)
    {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visit[start] = true;

        while(que.isEmpty() == false)
        {
            int cur = que.poll();

            ArrayList<Integer> curNode = graph.get(cur);
            for(int adj : curNode)
            {
                if(visit[adj] == true)
                    continue;

                que.add(adj);
                visit[adj] = true;

            }
        }
    }
}
