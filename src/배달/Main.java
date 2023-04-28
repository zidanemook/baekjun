package 배달;

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int N = 5;
        int K = 3;

        Solution sol = new Solution();
        sol.solution(N, road, K);
    }
}

class Solution
{
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        int[][] graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
        }

        for (int[] r : road) {
            int a = r[0] - 1;
            int b = r[1] - 1;
            int c = r[2];

            graph[a][b] = Math.min(graph[a][b], c);
            graph[b][a] = Math.min(graph[b][a], c);
        }

        int[] dist = dijkstra(graph, 0);

        for (int d : dist) {
            if (d <= K) {
                answer++;
            }
        }

        return answer;
    }

    public static int[] dijkstra(int[][] graph, int start) {
        int n = graph.length;
        int[] dist = new int[n];//배열은 시작점(1번 마을)을 기준으로 다른 정점(다른 마을)까지의 거리를 저장하는 배열
        boolean[] visited = new boolean[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int i = 0; i < n; i++) {
            int u = -1;

            for (int j = 0; j < n; j++) {
                if (!visited[j] && (u == -1 || dist[j] < dist[u])) {
                    u = j;
                }
            }

            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        return dist;
    }
}
