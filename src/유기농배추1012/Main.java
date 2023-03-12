package 유기농배추1012;

import java.io.*;
import java.util.*;

class Pos
{
    int r;
    int c;

    public Pos() {}

    public Pos(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());//test case
        String[] input;

        int count = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < t; ++i)
        {
            input = br.readLine().split(" ");

            int M = Integer.parseInt(input[0]);// row
            int N = Integer.parseInt(input[1]);// column
            int K = Integer.parseInt(input[2]);// count of cabbage

            int[][] bat = new int[M][N];

            for(int j = 0; j < K; ++j)
            {
                input = br.readLine().split(" ");

                int r = Integer.parseInt(input[0]);
                int c = Integer.parseInt(input[1]);
                bat[r][c] = 1;
            }

            boolean[][] visit = new boolean[M][N];
            for(int j = 0; j < M; ++j)
            {
                for(int k = 0; k < N; ++k)
                {
                    if(bat[j][k] == 1 && visit[j][k] == false)
                    {
                        dfs(bat, j, k, visit);
                        count++;
                    }

                }
            }
            ans.add(count);
            count = 0;
        }

        ans.forEach(i-> System.out.println(i));

    }

    private static void dfs(int[][] bat, int j, int k, boolean[][] visit)
    {
        Pos start = new Pos(j, k);
        Stack<Pos> stack = new Stack<>();

        stack.push(start);

        while(stack.isEmpty() == false)
        {
            Pos cur = stack.peek();

            Pos[] next = new Pos[4];
            next[0] = new Pos(cur.r-1, cur.c);
            next[1] = new Pos(cur.r, cur.c+1);
            next[2] = new Pos(cur.r+1, cur.c);
            next[3] = new Pos(cur.r, cur.c-1);

            boolean noWhereToGo = true;
            for(int i = 0; i < 4; ++i)
            {
                if(next[i].r < 0 || next[i].r >= bat.length
                || next[i].c < 0 || next[i].c >= bat[0].length)
                    continue;

                if(bat[next[i].r][next[i].c] == 0)
                    continue;

                if(visit[next[i].r][next[i].c] == false)
                {
                    visit[next[i].r][next[i].c] = true;
                    stack.push(next[i]);
                    noWhereToGo = false;
                    break;
                }
            }
            if(noWhereToGo)
                stack.pop();
        }
    }
}
