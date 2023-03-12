package 빙산2573;

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

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] ocean = new int[N][M];

        for(int i = 0; i < N; ++i)
        {
            input = br.readLine().split(" ");
            for(int j = 0; j < M; ++j)
            {
                ocean[i][j] = Integer.parseInt(input[j]);
            }
        }

        int pieces = 0;
        int year = 0;
        while(true)
        {
            boolean[][] visit = new boolean[N][M];
            int[][] newOcena = new int[N][M];

            for(int i = 0; i < N; ++i)
            {
                for(int j = 0; j < M; ++j)
                {
                    if(ocean[i][j] != 0 && visit[i][j] == false)
                    {
                        bfs(i, j, ocean, newOcena, N, M, visit);
                        pieces++;
                    }
                }
            }

            if(pieces >= 2)
                break;

            pieces = 0;

            for(int i = 0; i < N; ++i)
            {
                ocean[i] = Arrays.copyOfRange(newOcena[i], 0, M);
            }

            if(existIce(ocean, N, M) == false)
                break;

            year++;
        }

        if(pieces >= 2)
            System.out.println(year);
        else
            System.out.println(0);
    }

    private static void bfs(int r, int c, int[][] ocean, int[][] newOcean, int N, int M, boolean[][] visit)
    {
        Queue<Pos> que = new LinkedList<>();

        que.add(new Pos(r, c));
        visit[r][c] = true;
        Pos[] newPos = new Pos[4];

        while(que.isEmpty() == false)
        {
            Pos cur = que.poll();
            newPos[0] = new Pos(cur.r-1, cur.c);
            newPos[1] = new Pos(cur.r, cur.c+1);
            newPos[2] = new Pos(cur.r+1, cur.c);
            newPos[3] = new Pos(cur.r, cur.c-1);

            int adjOcean = 0;
            for(int i = 0; i < 4; ++i)
            {
                if(newPos[i].r < 0 || newPos[i].r >= N
                || newPos[i].c < 0 || newPos[i].c >= M)
                    continue;

                if(ocean[newPos[i].r][newPos[i].c] == 0)
                {
                    adjOcean++;
                    continue;
                }

                if(visit[newPos[i].r][newPos[i].c] == true)
                    continue;

                que.add(newPos[i]);
                visit[newPos[i].r][newPos[i].c] = true;
            }

            newOcean[cur.r][cur.c] = Math.max(0, ocean[cur.r][cur.c] - adjOcean);

        }

    }

    public static boolean existIce(int[][] ocean, int N, int M)
    {
        boolean Ice = false;
        for(int i = 0; i < N; ++i)
        {
            for(int j = 0; j < M; ++j)
            {
                if(0 == ocean[i][j])
                    continue;

                Ice = true;

            }
        }

        return Ice;
    }
}
