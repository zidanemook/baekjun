package 택배배송5972;

import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {

    int vertex;
    int cow;

    Edge(int vertex, int cow)
    {
        this.vertex = vertex;
        this.cow = cow;
    }

    @Override
    public int compareTo(Edge o)
    {
        return this.cow < o.cow ? -1 : 1;
    }

}

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        int[] dist = new int[N+1];
        for (int i = 0; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));

        dist[1] = 0;

        while(pq.isEmpty() == false)
        {
            Edge mid = pq.poll();

            if(dist[mid.vertex] < mid.cow)
                continue;

            ArrayList<Edge> nei = graph.get(mid.vertex);
            for(Edge dest : nei){

                int newdist = dist[mid.vertex] + dest.cow;

                if(newdist < dist[dest.vertex])
                {
                    dist[dest.vertex] = newdist;
                    pq.add(new Edge(dest.vertex, newdist));
                }
            }
        }

        System.out.println(dist[N]);
    }
}
