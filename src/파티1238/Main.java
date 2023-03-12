package 파티1238;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node>
{
    int dest;
    int cost;

    public Node() {
    }

    public Node(int dest, int cost) {
        this.dest = dest;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost < o.cost ? -1 : 1;
    }
}


public class Main
{
    static int N;
    static int M;
    static int X;

    static int[] d;//cost, pre node
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);//1 ~ 1000
        M = Integer.parseInt(input[1]);//1 ~ 10000
        X = Integer.parseInt(input[2]);//1 ~ N

        for(int i = 0; i < N+1; ++i)
            graph.add(new ArrayList<>());

        d = new int[N+1];

        for(int i = 0; i < M; ++i)
        {
            input = br.readLine().split(" ");

            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);
            graph.get(u).add(new Node(v, w));
        }

        int[] student = new int[N+1];
        //각 마을에서 출발  X도착 비용
        for(int i = 1; i < student.length;++i)
        {
            if(i != X)
                student[i] = dijkstra(i, X);
        }

        // X마을에서 모든 마을 도착 비용
        dijkstra(X, 1);

        int maxCost = 0;
        for(int i = 1; i < student.length;++i)
        {
            student[i] += d[i];
            maxCost = Math.max(maxCost, student[i]);
        }

        System.out.println(maxCost);
    }

    public static int dijkstra(int start, int end)
    {

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int i = 0; i < N+1; ++i)
        {
            d[i] = Integer.MAX_VALUE;
        }


        pq.add(new Node(start, 0));
        d[start] = 0;

        while(pq.isEmpty() == false)
        {
            Node cur = pq.poll();

            if(cur.cost > d[cur.dest])
                continue;

            ArrayList<Node> adjList = graph.get(cur.dest);
            for(int i = 0; i < adjList.size(); ++i)
            {
                Node adj = adjList.get(i);
                int cost = d[cur.dest] + adj.cost;

                if(cost < d[adj.dest])
                {
                    d[adj.dest] = cost;
                    pq.add(new Node(adj.dest, cost));
                }
            }
        }

        return d[end];
    }
}
