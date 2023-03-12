package 케빈베이컨의6단계법칙1389;

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

        for(int i = 0;i < M; ++i)
        {
            input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] visit = new int[N+1];
        Arrays.fill(visit, -1);

        int min = Integer.MAX_VALUE;
        ArrayList<Integer> cand = new ArrayList<>();

        for(int i = 1; i < N+1; ++i)
        {
            int kevin = bfs(i, N, graph, visit);
            if(min > kevin)
            {
                min = kevin;
                cand.clear();
                cand.add(i);
            }
            else if(min == kevin)
            {
                cand.add(i);
            }
            Arrays.fill(visit, -1);
        }

        Collections.sort(cand);
        System.out.println(cand.get(0));
    }

    private static int bfs(int start, int N, ArrayList<ArrayList<Integer>> graph, int[] visit)
    {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visit[start] = 0;

        while(que.isEmpty() == false)
        {
            int cur = que.poll();

            ArrayList<Integer> curNode = graph.get(cur);
            for(int i = 0; i < curNode.size(); ++i)
            {
                int adj = curNode.get(i);

                if(visit[adj] != -1)
                    continue;

                que.add(adj);
                visit[adj] = visit[cur]+1;
            }
        }

        int ret = 0;
        for(int element: visit)
        {
            if(element == -1)
                continue;

            ret += element;
        }

        return ret;
    }
}
