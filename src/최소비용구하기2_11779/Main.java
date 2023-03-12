package 최소비용구하기2_11779;

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

    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());//1 ~ 1000
        M = Integer.parseInt(br.readLine());//1 ~ 10000

        for(int i = 0; i < N+1; ++i)
            graph.add(new ArrayList<>());

        String[] input;
        for(int i = 0; i < M; ++i)
        {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int dist = Integer.parseInt(input[2]);//0 ~ 100000

            graph.get(u).add(new Node(v, dist));
        }

        input = br.readLine().split(" ");

        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        djikstra(start, end);
    }

    public static void djikstra(int start, int end)
    {
        int[][] d = new int[N+1][2];
        for(int i = 0; i < N+1; ++i)
            d[i][0] = Integer.MAX_VALUE;

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(start, 0));
        d[start][0] = 0;
        d[start][1] = start;

        while(pq.isEmpty() == false)
        {
            Node curNode = pq.poll();

            if(curNode.cost > d[curNode.dest][0])
                continue;

            ArrayList<Node> adjList = graph.get(curNode.dest);
            for(int i = 0; i < adjList.size(); ++i)
            {
                Node adj = adjList.get(i);

                int cost = d[curNode.dest][0] + adj.cost;
                if(d[adj.dest][0] > cost)
                {
                    d[adj.dest][0] = cost;
                    d[adj.dest][1] = curNode.dest;
                    pq.add(new Node(adj.dest, cost));
                }
            }

        }

        System.out.println(d[end][0]);

        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        int before = end;
        while(true)
        {
            before = d[before][1];
            stack.push(before);

            if(before == start)
                break;
        }

        System.out.println(stack.size());

        while(stack.isEmpty()==false)
        {
            System.out.print(stack.pop() + " ");
        }

    }
}
