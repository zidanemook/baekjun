package 특정한최단경로1504;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node>
{
    int dest;
    int dis;

    public Node() {
    }

    public Node(int dest, int dis) {
        this.dest = dest;
        this.dis = dis;
    }

    @Override
    public int compareTo(Node o) {
        return this.dis < o.dis ? -1 : 1;
    }
}

public class Main
{
    static int N;
    static int E;

    static int[] dis;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    static int v1;
    static int v2;

    static final int MAX = 200000000;

    public static void main(String[] args) throws IOException
    {
        inputProcess();

        int ans1 = 0;
        int ans2 = 0;

        Arrays.fill(dis, MAX);
        djikstra(1);
        ans1 += dis[v1];

        Arrays.fill(dis, MAX);
        djikstra(v1);
        ans1 += dis[v2];

        Arrays.fill(dis, MAX);
        djikstra(v2);
        ans1 += dis[N];


        Arrays.fill(dis, MAX);
        djikstra(1);
        ans2 += dis[v2];

        Arrays.fill(dis, MAX);
        djikstra(v2);
        ans2 += dis[v1];

        Arrays.fill(dis, MAX);
        djikstra(v1);
        ans2 += dis[N];

        if(ans1 >= MAX || ans2 >= MAX)
            System.out.println(-1);
        else
            System.out.println(Math.min(ans1, ans2));
    }

    public static void inputProcess() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);

        for(int i = 0; i < N+1; ++i)
            graph.add(new ArrayList<>());

        dis = new int[N+1];

        for(int i = 0; i < E; ++i)
        {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int dest = Integer.parseInt(input[1]);
            int dis = Integer.parseInt(input[2]);

            graph.get(start).add(new Node(dest, dis));
            graph.get(dest).add(new Node(start, dis));
        }

        input = br.readLine().split(" ");
        v1 = Integer.parseInt(input[0]);
        v2 = Integer.parseInt(input[1]);
    }
    public static void djikstra(int start)
    {
        dis[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while(pq.isEmpty() == false)
        {
            Node curNode = pq.poll();

            if(dis[curNode.dest] < curNode.dis)
                continue;

            ArrayList<Node> adjList = graph.get(curNode.dest);
            for(int i = 0; i < adjList.size(); ++i)
            {
                Node adjNode = adjList.get(i);

                int cost = dis[curNode.dest] + adjNode.dis;
                if(cost < dis[adjNode.dest])
                {
                    dis[adjNode.dest] = cost;
                    pq.add(new Node(adjNode.dest, cost));
                }
            }
        }
    }
}
