package 음식물피하기1743;

import java.io.*;
import java.util.*;

class Pos
{
    int r;
    int c;

    public Pos() {
    }

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
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        int[][] building = new int[N+1][M+1];
        int r = 0;
        int c = 0;

        for(int i = 0; i < K; ++i)
        {
            input = br.readLine().split(" ");
            r = Integer.parseInt(input[0]);
            c = Integer.parseInt(input[1]);
            building[r][c] = 1;
        }

        int ans = 0;
        boolean[][] visit = new boolean[N+1][M+1];
        for(int i = 1; i < N+1; ++i)
        {
            for(int j = 1; j < M+1; ++j)
            {
                if(building[i][j] == 1 && visit[i][j] == false)
                {
                    ans = Math.max(ans, dfs(i, j, building, visit));
                }

            }
        }

        System.out.println(ans);
    }

    private static int dfs(int r, int c, int[][] building, boolean[][] visit)
    {
        int ret = 1;

        Pos start = new Pos(r, c);

        Stack<Pos> stack = new Stack<>();
        stack.push(start);
        visit[r][c] = true;
        Pos[] newPos = new Pos[4];

        while(stack.isEmpty() == false)
        {
            Pos cur = stack.peek();

            newPos[0] = new Pos(cur.r-1, cur.c);
            newPos[1] = new Pos(cur.r, cur.c+1);
            newPos[2] = new Pos(cur.r+1, cur.c);
            newPos[3] = new Pos(cur.r, cur.c-1);

            boolean noVisit = true;
            for(int i = 0; i < 4; ++i)
            {
                if(newPos[i].r < 1 || newPos[i].r >= building.length
                        || newPos[i].c < 1 || newPos[i].c >= building[0].length)
                    continue;

                if(visit[newPos[i].r][newPos[i].c] == true)
                    continue;

                if(building[newPos[i].r][newPos[i].c] == 0)
                    continue;

                stack.push(newPos[i]);
                visit[newPos[i].r][newPos[i].c] = true;
                noVisit = false;
                ret++;
                break;
            }
            if(noVisit)
                stack.pop();
        }

        return ret;
    }
}
