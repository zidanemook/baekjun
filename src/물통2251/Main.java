package 물통2251;

import java.io.*;
import java.util.*;


public class Main
{
    static class State
    {
        int[] w = new int[3];

        public State() {
        }

        public State(int a, int b, int c) {
            this.w[0] = a;
            this.w[1] = b;
            this.w[2] = c;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int C = Integer.parseInt(input[2]);

        int[] capacity = {A, B, C};
        boolean[][][] visit = new boolean[A+1][B+1][C+1];
        HashSet<Integer> ans = new HashSet<>();

        bfs(new State(0, 0, capacity[2]), visit, capacity, ans);

        Object[] temp = ans.toArray();
        Arrays.sort(temp);
        Arrays.stream(temp).forEach(i-> System.out.print(i+" "));
    }

    public static void bfs(State state, boolean[][][] visit, int[] capacity, HashSet<Integer> ans)
    {
        Queue<State> que = new LinkedList<>();

        que.add(state);
        visit[state.w[0]][state.w[1]][state.w[2]] = true;

        if(state.w[0] == 0)
            ans.add(state.w[2]);

        while(que.isEmpty() == false)
        {
            State cur = que.poll();

            for(int i = 0; i < 3; ++i)
            {
                for(int j = 0; j < 3; ++j)
                {
                    for(int k = 0; k < 3; ++k)
                    {
                        if(i != j && i != k && j != k
                        && cur.w[j] > 0)
                        {
                            NextState(cur, i, j, k, que, visit, capacity, ans);
                        }
                    }
                }
            }
        }
    }

    private static void NextState(State cur, int i, int j, int k, Queue<State> que, boolean[][][] visit, int[] capacity, HashSet<Integer> ans)
    {

        //from j -> k
        if(cur.w[j] <= (capacity[k] - cur.w[k]))
        {
            State newState = new State();
            newState.w[i] = cur.w[i];
            newState.w[j] = 0;
            newState.w[k] = cur.w[j] + cur.w[k];
            if(visit[newState.w[0]][newState.w[1]][newState.w[2]] == false)
            {
                que.add(newState);
                visit[newState.w[0]][newState.w[1]][newState.w[2]] = true;

                if(newState.w[0] == 0)
                    ans.add(newState.w[2]);
            }

        }
        else
        {
            State newState = new State();
            newState.w[i] = cur.w[i];
            newState.w[j] = cur.w[j] - (capacity[k] - cur.w[k]);
            newState.w[k] = capacity[k];

            if(visit[newState.w[0]][newState.w[1]][newState.w[2]] == false)
            {
                que.add(newState);
                visit[newState.w[0]][newState.w[1]][newState.w[2]] = true;

                if(newState.w[0] == 0)
                    ans.add(newState.w[2]);
            }
        }
    }
}
