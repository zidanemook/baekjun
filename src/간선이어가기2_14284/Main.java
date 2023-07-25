package 간선이어가기2_14284;

import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
    int dest;
    int cost;
    Edge(int dest, int cost){
        this.dest = dest;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o){
        return this.cost < o.cost ? -1 : 1;
    }
}

public class Main {

    static int n;
    static int m;

    static ArrayList<ArrayList<Edge>> map = new ArrayList<>();
    static int[][] d;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input  = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            map.get(a).add(new Edge(b, c));
            map.get(b).add(new Edge(a, c));
        }

        input = br.readLine().split(" ");
        int s = Integer.parseInt(input[0]);
        int t = Integer.parseInt(input[1]);

        d = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j)
                    d[i][j] = 0;
                else
                    d[i][j] = Integer.MAX_VALUE;
            }
        }

        dijkstra(s);

        System.out.println(d[s][t]);
    }

    public static void dijkstra(int start){
        PriorityQueue<Edge> pq  = new PriorityQueue<>();

        pq.add(new Edge(start, 0));

        while(pq.isEmpty() == false){

            Edge ecur = pq.poll();

            if(d[start][ecur.dest] < ecur.cost)
                continue;

            ArrayList<Edge> cur = map.get(ecur.dest);

            for (int i = 0; i < cur.size(); i++) {

                Edge edge = cur.get(i);

                if(d[start][edge.dest] > d[start][ecur.dest] + edge.cost){
                    d[start][edge.dest] = d[start][ecur.dest] + edge.cost;
                    pq.add(new Edge(edge.dest, d[start][edge.dest]));
                }
            }
        }
    }
}
