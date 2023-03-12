package 바이러스2606;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vn = Integer.parseInt(br.readLine());//vertex count

        int en = Integer.parseInt(br.readLine());//edge count

        String[] input;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < vn+1; ++i)
            graph.add(new ArrayList<>());

        for(int i = 0; i < en; ++i)
        {
            input = br.readLine().split(" ");
            graph.get(Integer.parseInt(input[0])).add(Integer.parseInt(input[1]));
            graph.get(Integer.parseInt(input[1])).add(Integer.parseInt(input[0]));
        }

        int start = 1;
        boolean[] visit = new boolean[vn+1];
        dfs(start, graph, visit);
    }

    private static void dfs(int start, ArrayList<ArrayList<Integer>> graph, boolean[] visit)
    {
        Stack<Integer> stack = new Stack<>();

        stack.push(start);
        visit[start] = true;
        int ans = 0;
        while(stack.isEmpty() == false)
        {
            int cur = stack.peek();

            ArrayList<Integer> curNode = graph.get(cur);
            boolean noWhereToGo = true;
            for(int element : curNode)
            {
                if(visit[element] == false)
                {
                    visit[element] = true;
                    stack.push(element);
                    noWhereToGo = false;
                    ans++;
                    break;
                }
            }
            if(noWhereToGo)
                stack.pop();
        }

        System.out.println(ans);
    }
}
