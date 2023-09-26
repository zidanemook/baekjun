package 친구1058;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] fcnt = new int[N];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {

            String[] input = br.readLine().split("");

            for (int j = 0; j < N; j++) {
                if(input[j].equals("Y"))
                {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, find(i, N, graph));
        }

        System.out.println(ans);
    }

    public static int find(int start, int N, ArrayList<ArrayList<Integer>> graph)
    {
        Queue<int[]> que = new LinkedList<>();
        boolean[] visit = new boolean[N];
        que.add(new int[]{start, 0});
        visit[start] = true;

        int cnt = 0;
        while(que.isEmpty()==false)
        {
            int[] cur = que.poll();

            if(cur[1]+1 > 2)
                continue;

            ArrayList<Integer> neilist = graph.get(cur[0]);
            for (int i = 0; i < neilist.size(); i++) {
                int neighbor = neilist.get(i);

                if(visit[neighbor])
                    continue;

                visit[neighbor] = true;

                que.add(new int[]{neighbor, cur[1]+1});
                cnt++;
            }

        }
        return cnt;
    }
}
