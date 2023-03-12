package 결혼식5567;

import java.io.*;
import java.util.*;

public class Main
{
    static int testcount = 0;//testcode

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> friend = new ArrayList<>();
        for(int i = 0; i < N+1; ++i)
        {
            friend.add(new ArrayList<>());
        }
        int[] visit = new int[N+1];
        for(int i = 0; i < N+1; ++i)
            Arrays.fill(visit, -1);

        String[] input;
        for(int i = 0; i < M; ++i)
        {
            input = br.readLine().split(" ");
            friend.get(Integer.parseInt(input[0])).add(Integer.parseInt(input[1]));
            friend.get(Integer.parseInt(input[1])).add(Integer.parseInt(input[0]));
        }

        bfs(1, friend, visit);
    }

    private static void bfs(int start, ArrayList<ArrayList<Integer>> friend, int[] visit)
    {
        Queue<Integer> que = new LinkedList<>();

        que.add(start);
        visit[start] = 0;
        int ans = 0;

        while(que.isEmpty() == false)
        {
            int cur = que.poll();
            ArrayList<Integer> curNode = friend.get(cur);

            for(int element:curNode)
            {
                testcount++;

                if(visit[element] == -1 && visit[cur] < 2)
                {
                    ans++;

                    visit[element] = visit[cur]+1;
                    que.add(element);
                }
            }
        }

        System.out.println(ans);
        System.out.println(testcount);
    }
}
