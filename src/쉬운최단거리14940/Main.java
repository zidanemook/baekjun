package 쉬운최단거리14940;

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

        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        int[][] map = new int[R][C];

        Queue<Pos> que = new LinkedList<>();
        for(int i = 0; i < R; ++i)
        {
            input = br.readLine().split(" ");
            for(int j = 0; j < C; ++j)
            {
                int value = Integer.parseInt(input[j]);

                if(value == 1)
                    map[i][j] = -1;
                else if(value == 2)
                {
                    que.add(new Pos(i, j));
                    map[i][j] = 0;
                }

                else if (value == 0)
                    map[i][j] = 0;
            }
        }

        boolean[][] visit = new boolean[R][C];
        bfs(que, R, C, map, visit);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < R; ++i)
        {
            for(int j = 0; j < C; ++j)
            {
                if(j == C-1)
                    sb.append(map[i][j]);
                else
                    sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(Queue<Pos> que, int R, int C, int[][] map, boolean[][] visit)
    {
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        Pos start = que.peek();
        visit[start.r][start.c] = true;

        while(que.isEmpty() == false)
        {
            Pos cur = que.poll();

            for(int i = 0; i < 4; ++i)
            {
                int r = cur.r + dir[i][0];
                int c = cur.c + dir[i][1];

                if(r < 0 || r >= R || c < 0 || c >= C)
                    continue;

                if(map[r][c] != -1)
                    continue;

                if(visit[r][c] == true)
                    continue;

                que.add(new Pos(r, c));
                visit[r][c] = true;
                map[r][c] = map[cur.r][cur.c]+1;
            }
        }
    }
}
