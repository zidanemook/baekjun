package 섬의개수4963;

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

        String[] input = null;

        int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

        while(true)
        {
            input = br.readLine().split(" ");
            int C = Integer.parseInt(input[0]);
            int R = Integer.parseInt(input[1]);
            int[][] map = new int[R][C];

            if(R == 0 && C == 0)
                break;

            for(int i = 0; i < R; ++i)
            {
                input = br.readLine().split(" ");
                for (int j = 0; j < C; ++j)
                {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }

            boolean[][] visit = new boolean[R][C];
            int count = 0;
            for(int i = 0; i < R; ++i)
            {
                for(int j = 0;j < C; ++j)
                {
                    if(map[i][j] == 1 && visit[i][j] == false)
                    {
                        bfs(new Pos(i, j) ,map, R, C, visit, dir);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void bfs(Pos pos, int[][] map, int R, int C, boolean[][] visit, int[][] dir)
    {
        Queue<Pos> que = new LinkedList<>();
        que.add(pos);
        visit[pos.r][pos.c] = true;

        while(que.isEmpty() == false)
        {
            Pos cur = que.poll();

            for(int i = 0; i < 8; ++i)
            {
                int r = cur.r + dir[i][0];
                int c = cur.c + dir[i][1];

                if(r < 0 || r >= R || c < 0 || c >= C)
                    continue;

                if(visit[r][c] == true)
                    continue;

                if(map[r][c] == 0)
                    continue;

                que.add(new Pos(r, c));
                visit[r][c] = true;
            }
        }
    }
}
