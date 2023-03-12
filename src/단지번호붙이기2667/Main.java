package 단지번호붙이기2667;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        String[] input;
        for(int i = 0; i < n; ++i)
        {
            input = br.readLine().split("");
            for(int j = 0; j < n; ++j)
            {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        boolean[][] visit = new boolean[n][n];
        int danji = 0;
        ArrayList<Integer> jip = new ArrayList<>();
        for(int i = 0; i < n; ++i)
        {
            for(int j = 0; j < n; ++j)
            {
                if(map[i][j] != 0 && visit[i][j]==false)
                {
                    dfs(i, j, visit, map, jip);
                    danji++;
                }

            }
        }

        Collections.sort(jip);

        System.out.println(danji);
        jip.stream().forEach(i-> System.out.println(i));
    }

    private static void dfs(int i, int j, boolean[][] visit, int[][] map, ArrayList<Integer> jip)
    {
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

        Pos start = new Pos(i, j);
        visit[i][j] = true;
        Stack<Pos> stack = new Stack<>();
        stack.push(start);
        Pos[] newPos = new Pos[4];

        int jipcnt = 1;
        while(stack.isEmpty() == false)
        {
            Pos cur = stack.peek();

            newPos[0] = new Pos(cur.r-1, cur.c);//up
            newPos[1] = new Pos(cur.r, cur.c+1);//right
            newPos[2] = new Pos(cur.r+1, cur.c);//down
            newPos[3] = new Pos(cur.r, cur.c-1);//left

            boolean noWhereToGo = true;
            for(int k = 0; k < 4; ++k)
            {
                if(newPos[k].r >= 0 && newPos[k].r < map.length
                && newPos[k].c >= 0 && newPos[k].c < map.length
                && visit[newPos[k].r][newPos[k].c] == false
                && map[newPos[k].r][newPos[k].c] == 1)
                {
                    visit[newPos[k].r][newPos[k].c] = true;
                    jipcnt++;
                    noWhereToGo = false;
                    stack.push(newPos[k]);
                    break;
                }
            }
            if(noWhereToGo)
                stack.pop();
        }
        jip.add(jipcnt);
    }
}
