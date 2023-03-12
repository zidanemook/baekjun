package 택배1719;

import java.util.*;
import java.io.*;

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
        return this.dis < o.dis ? -1:1;
    }
}

public class Main
{

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        PriorityQueue<Node> pq = new PriorityQueue<>();

        int[][] ans = new int[n+1][n+1];

        for(int i = 0; i < n+1; ++i)
        {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; ++i)
        {
            input = br.readLine().split(" ");

            int s = Integer.parseInt(input[0]);//start
            int d = Integer.parseInt(input[1]);//destination
            int dis = Integer.parseInt(input[2]);

            graph.get(s).add(new Node(d, dis));
            graph.get(d).add(new Node(s, dis));
        }

        int[] d = new int[n+1];
        Arrays.fill(d, Integer.MAX_VALUE);
        for(int i = 1; i < n+1; ++i)
        {
            pq.add(new Node(i, 0));
            d[i]=0;

            while(pq.isEmpty() == false)
            {
                Node curNode = pq.poll();

                if(d[curNode.dest] < curNode.dis)
                    continue;

                ArrayList<Node> adjList = graph.get(curNode.dest);
                for(int j = 0; j < adjList.size(); ++j)
                {
                    Node adjNode = adjList.get(j);
                    int cost = d[curNode.dest] + adjNode.dis;

                    if(cost < d[adjNode.dest])
                    {
                        if(curNode.dest == i)
                            ans[i][adjNode.dest] = adjNode.dest;
                        else
                            ans[i][adjNode.dest] = ans[i][curNode.dest];

                        d[adjNode.dest] = cost;
                        pq.add(new Node(adjNode.dest, cost));
                    }
                }
            }

            Arrays.fill(d, Integer.MAX_VALUE);
        }

        int num = 0;
        for(int i = 1; i < ans.length; ++i)
        {
            for(int j = 1; j < ans[0].length; ++j)
            {
                num = ans[i][j];
                if(j != (ans[0].length -1))
                {
                    if(num == 0)
                        System.out.print("-" + " ");
                    else
                        System.out.print(num + " ");
                }
                else
                {
                    if(num == 0)
                        System.out.println("-");
                    else
                        System.out.println(num);
                }

            }
        }
    }
}
