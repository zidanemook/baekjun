package 등산코스정하기;

import java.util.*;

class Solution {

    class Edge implements Comparable<Edge>{
        int nei = 0;
        int len = 0;

        Edge(int nei, int len){
            this.nei = nei;
            this.len = len;
        }

        @Override
        public int compareTo(Edge o){
            return len < o.len ? -1 : 1;
        }
    }
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i = 0; i <= n; ++i){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < paths.length; ++i){

            int a = paths[i][0];
            int b = paths[i][1];
            int len = paths[i][2];

            if(isGate(a, gates) || isSummit(b, summits)){
                graph.get(a).add(new Edge(b, len));
            }else if(isGate(b, gates) || isGate(a, summits)){
                graph.get(b).add(new Edge(a, len));
            }else{
                graph.get(a).add(new Edge(b, len));
                graph.get(b).add(new Edge(a, len));
            }

        }

        return dijkstra(graph, n, gates, summits);
    }

    public int[] dijkstra(ArrayList<ArrayList<Edge>> graph, int n, int[] gates, int[] summits) {
        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>(); // 우선 순위 큐로 변경

        for (int gate : gates) {
            pq.add(new Edge(gate, 0));
            intensity[gate] = 0;
        }

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (cur.len > intensity[cur.nei])
                continue;

            for (int i = 0; i < graph.get(cur.nei).size(); ++i) {
                Edge nei = graph.get(cur.nei).get(i);

                int dist = Math.max(intensity[cur.nei], nei.len);
                if (intensity[nei.nei] > dist) {
                    intensity[nei.nei] = dist;
                    pq.add(new Edge(nei.nei, dist)); // 간선 정보를 우선 순위 큐에 추가
                }
            }
        }

        int summitidx = Integer.MAX_VALUE;
        int minintensity = Integer.MAX_VALUE;

        Arrays.sort(summits);

        for (int summit : summits) {
            if (intensity[summit] < minintensity) {
                summitidx = summit;
                minintensity = intensity[summit];
            }
        }

        return new int[] { summitidx, minintensity };
    }

    private boolean isGate(int num, int[] gates) {
        for (int gate : gates) {
            if (num == gate) return true;
        }
        return false;
    }

    private boolean isSummit(int num, int[] submits) {
        for (int submit : submits) {
            if (num == submit) return true;
        }
        return false;
    }
}


public class Main {
    public static void main(String[] args) {

        Solution sol = new Solution();

        int[][] paths = {{1,2,3,},{2,3,5},{2,4,2}, {2, 5, 4},{3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}};
        int[] gates = {1, 3};
        int[] summits = {5};
        int[] answer = sol.solution(6, paths, gates, summits);

        for(int i : answer)
            System.out.println(i);

    }
}
