package 녹색옷입은애가젤다지4485;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node>
{
    int r;
    int c;

    int cost;

    public Node() {
    }

    public Node(int r, int c, int cost) {
        this.r = r;
        this.c = c;
        this.cost = cost;
    }


    @Override
    public int compareTo(Node o) {
        return this.cost < o.cost ? -1 : 1;
    }
}

public class Main
{
    static int[][] cave;
    static int N;

    static int[][] d;

    //static int count=0;//testcode

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        int tcNum = 1;
        while(true)
        {
            N = Integer.parseInt(br.readLine());
            if(N == 0)
                break;

            cave = new int[N][N];
            d = new int[N][N];

            for(int i = 0; i < N; ++i)
            {
                input = br.readLine().split(" ");
                for(int j = 0; j < N; ++j)
                {
                    cave[i][j] = Integer.parseInt(input[j]);
                }
            }

            dijkstra();

            System.out.println("Problem " + tcNum + ": " + d[N-1][N-1]);
            tcNum++;
        }

        //System.out.println(count);//testcode
    }

    public static void  dijkstra()
    {
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};


        for(int i = 0; i < N; ++i)
            Arrays.fill(d[i], Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, 0));
        d[0][0] = cave[0][0];

        Node adj = new Node();

        while(pq.isEmpty() == false)
        {
            Node cur = pq.poll();

            if(cur.cost > d[cur.r][cur.c])
                continue;

            for(int i = 0; i < 4; ++i)
            {
                adj.r = cur.r + dir[i][0];
                adj.c = cur.c + dir[i][1];

                if(adj.r < 0 || adj.r >= N)
                    continue;
                if(adj.c < 0 || adj.c >= N)
                    continue;

                int cost = d[cur.r][cur.c] + cave[adj.r][adj.c];
                if(cost >= d[adj.r][adj.c])
                    continue;

                //count++;//testcode
                d[adj.r][adj.c] = cost;
                pq.add(new Node(adj.r, adj.c, cost));

            }
        }
    }
}
