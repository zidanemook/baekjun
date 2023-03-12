package 촌수계산2644;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int fp = Integer.parseInt(input[0]);
        int sp = Integer.parseInt(input[1]);

        int rc = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> graph= new ArrayList<>();
        for(int i = 0; i < n+1; ++i)
            graph.add(new ArrayList<>());

        int[] visit = new int[n+1];
        Arrays.fill(visit, -1);

        for(int i = 0; i < rc; ++i)
        {
            input = br.readLine().split(" ");
            graph.get(Integer.parseInt(input[0])).add(Integer.parseInt(input[1]));
            graph.get(Integer.parseInt(input[1])).add(Integer.parseInt(input[0]));
        }

        bfs(fp, sp, graph, visit);
    }

    private static void bfs(int fp, int sp, ArrayList<ArrayList<Integer>> graph, int[] visit)
    {
        Queue<Integer> que = new LinkedList<>();

        que.add(fp);
        visit[fp] = 0;

        while(que.isEmpty() == false)
        {
            int cur = que.poll();

            ArrayList<Integer> curNode = graph.get(cur);
            for(int element : curNode)
            {
                if(visit[element] == -1)
                {
                    que.add(element);
                    visit[element] = visit[cur]+1;

                    if(element == sp)
                    {
                        System.out.println(visit[element]);
                        return;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
