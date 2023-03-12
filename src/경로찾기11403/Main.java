package 경로찾기11403;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= N; ++i)
        {
            graph.add(new ArrayList<>());
        }

        String[] input;
        for(int i = 1; i <= N; ++i)
        {
            input = br.readLine().split(" ");
            for(int j = 1; j <= N; ++j)
            {
                int num = Integer.parseInt(input[j-1]);
                if(num == 1)
                    graph.get(i).add(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; ++i)
        {
            for(int j = 1; j <= N; ++j)
            {
                if(dfs(i, j, graph, N))
                {
                    if(j == N)
                        sb.append(1);
                    else
                        sb.append(1 + " ");
                }
                else
                {
                    if(j == N)
                        sb.append(0);
                    else
                        sb.append(0 + " ");
                }

                if(j == N)
                    sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean dfs(int i, int j, ArrayList<ArrayList<Integer>> graph, int n)
    {
        Stack<Integer> stack = new Stack<>();

        stack.push(i);
        boolean[] visit = new boolean[n+1];
        visit[i] = true;

        while(stack.isEmpty() == false)
        {
            int cur = stack.peek();
            ArrayList<Integer> curNode = graph.get(cur);
            boolean noGo = true;
            for(int k = 0; k < curNode.size(); ++k)
            {
                int adj = curNode.get(k);
                if(adj == j)
                    return true;

                if(visit[adj] == true)
                    continue;

                stack.add(adj);
                visit[adj] = true;
                noGo = false;
                break;
            }

            if(noGo)
                stack.pop();
        }

        return false;
    }
}
