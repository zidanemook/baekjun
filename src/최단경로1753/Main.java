package 최단경로1753;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node>
{
    int v;
    int w;

    public Node() {
    }

    public Node(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return this.w < o.w ? -1 : 1 ;
    }
}

public class Main
{
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    static PriorityQueue<Node> queue = new PriorityQueue();
    static int V;
    static int E;
    static int K;

    static int[] dis;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        V = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);
        K = Integer.parseInt(br.readLine());

        dis = new int[V+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for(int i = 0; i < V+1; ++i)
            graph.add(new ArrayList<>());

        for(int i = 0; i < E; ++i)
        {
            input = br.readLine().split(" ");

            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);

            graph.get(u).add(new Node(v, w));
        }

        queue.add(new Node(K, 0));
        dis[K] = 0;

        while(queue.isEmpty() == false)
        {
            Node curNode = queue.poll();
            if(curNode.w > dis[curNode.v])
               continue;

            ArrayList<Node> adjList = graph.get(curNode.v);
            for(int i = 0; i < adjList.size(); ++i)
            {
                Node adj = adjList.get(i);

                int cost = dis[curNode.v] + adj.w;
                if( cost < dis[adj.v])
                {
                    queue.add(new Node(adj.v, cost));
                    dis[adj.v] = cost;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < V+1; ++i)
        {
            if( dis[i] == Integer.MAX_VALUE)
                sb.append("INF\n");
            else
                sb.append(dis[i] + "\n");
        }

        System.out.println(sb);

    }
}
