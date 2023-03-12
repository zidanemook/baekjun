package 미로탐색2178;

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
        int[][] miro = new int[N][M];
        for(int i = 0; i < N; ++i)
        {
            input = br.readLine().split("");
            for(int j = 0; j < M; ++j)
            {
                miro[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[][] visit = new int[N][M];
        for(int i = 0; i < N; ++i)
            Arrays.fill(visit[i], -1);

        int ans = 0;
        ans = bfs(new Pos(0, 0), N, M, miro, visit);

        System.out.println(ans);
    }

    public static int bfs(Pos start, int N, int M, int[][] miro, int[][] visit)
    {
        int ret = 0;

        Queue<Pos> que = new LinkedList<>();
        que.add(start);
        visit[start.r][start.c] = 1;

        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while (que.isEmpty() == false && ret == 0)
        {
            Pos cur = que.poll();

            for(int i = 0; i < 4; ++i)
            {
                int r = cur.r + dir[i][0];
                int c = cur.c + dir[i][1];

                if(r < 0 || r >= N || c < 0 || c >= M || visit[r][c] != -1)
                    continue;

                if(miro[r][c] == 0)
                    continue;

                que.add(new Pos(r, c));
                visit[r][c] = visit[cur.r][cur.c]+1;

                if(r == N-1 && c == M-1)
                {
                    ret = visit[r][c];
                    break;
                }
            }
        }

        return ret;
    }
}
