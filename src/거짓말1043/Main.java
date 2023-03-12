package 거짓말1043;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int truthCnt = Integer.parseInt(input[0]);

        if(truthCnt == 0)
        {
            System.out.println(M);
            return;
        }

        Queue<Integer> truth = new LinkedList<>();//진실을 아는 사람
        for(int i = 1; i < truthCnt+1; ++i)
        {
            truth.add(Integer.parseInt(input[i]));
        }

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();//사람들간 연결관계
        for(int i = 0; i < N+1; ++i)
        {
            graph.add(new ArrayList<>());
        }

        HashSet<Integer>[] party = new HashSet[M];// 파티별 구성원
        for(int i = 0; i < M; ++i)
            party[i] = new HashSet<Integer>();

        for(int i = 0; i < M; ++i)
        {
            input = br.readLine().split(" ");
            int personCnt = Integer.parseInt(input[0]);
            int[] temp = new int[personCnt];
            for(int j = 0; j < personCnt; ++j)
            {
                temp[j] = Integer.parseInt(input[j+1]);
                party[i].add(temp[j]);
            }

            for(int j = 0; j < personCnt; ++j)
            {
                for(int k = 0; k < personCnt; ++k)
                {
                    if(j == k)
                        continue;

                    graph.get(temp[j]).add(temp[k]);//사람간 연결 관계
                }
            }
        }

        boolean[] visit = new boolean[N+1];

        bfs(truth, graph, N, visit);//사람간 연결관계를 통해 진실을 아는자 찾기

        int count = 0;
        for(int i = 0; i < M; ++i)//파티마다 진실을 아는자 한명이라도 있는지 찾기
        {
            boolean truthInParty = false;
            for(int j = 1; j < visit.length; ++j)
            {
                if(visit[j] == false)
                    continue;

                if(party[i].contains(j))
                {
                    truthInParty = true;
                    break;
                }
            }
            if(false == truthInParty)
                count++;
        }

        System.out.println(count);
    }

    private static void bfs(Queue<Integer> truth, ArrayList<ArrayList<Integer>> graph, int N, boolean[] visit)
    {
        for(int ele : truth)
        {
            visit[ele] = true;
        }

        while(truth.isEmpty() == false)
        {
            int cur = truth.poll();

            ArrayList<Integer> curNode = graph.get(cur);
            for(int i = 0; i < curNode.size(); ++i)
            {
                int adj = curNode.get(i);
                if(visit[adj] == true)
                    continue;

                visit[adj] = true;
                truth.add(adj);
            }
        }
    }
}
