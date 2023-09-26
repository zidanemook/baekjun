package 지름길1446;

import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int vertex, weight;

    public Edge(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight, o.weight);
    }
}


public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= D; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());//시작
            int end = Integer.parseInt(st.nextToken());//도착
            int weight = Integer.parseInt(st.nextToken());//길이
            if(end <= D)
                graph.get(start).add(new Edge(end, weight));
        }

        for (int i = 0; i < D; ++i) {
            graph.get(i).add(new Edge(i + 1, 1));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] dist = new int[D + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new Edge(0, 0));
        dist[0] = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            if (current.weight > dist[current.vertex]) {
                continue;
            }

            for (Edge next : graph.get(current.vertex)) {
                int nextDist = current.weight + next.weight;
                if (nextDist < dist[next.vertex]) {
                    dist[next.vertex] = nextDist;
                    pq.add(new Edge(next.vertex, nextDist));
                }
            }
        }

        // 결과 출력
        System.out.println(dist[D]);
    }
}
