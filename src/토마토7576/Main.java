package 토마토7576;

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

        int M = Integer.parseInt(input[0]);//column
        int N = Integer.parseInt(input[1]);//row

        int[][] box = new int[N][M];//0 ,1
        int[][] visit = new int[N][M];
        for(int i = 0; i < N; ++i)
            Arrays.fill(visit[i], -1);

        Queue<Pos> que = new LinkedList<>();

        for(int i = 0; i < N; ++i)
        {
            input = br.readLine().split(" ");
            for(int j = 0; j < M; ++j)
            {
                if(Integer.parseInt(input[j]) == 1)
                {
                    box[i][j] = 1;
                    que.add(new Pos(i, j));
                    visit[i][j] = 0;
                }
                else if(Integer.parseInt(input[j]) == -1)
                {
                    box[i][j] = -1;
                }
            }
        }

        bfs(que, box, visit);
    }

    private static void bfs(Queue<Pos> que, int[][] box, int[][] visit)
    {
        int ans = 0;
        while(que.isEmpty() == false)
        {
            Pos cur = que.poll();

            Pos[] nP = new Pos[4];

            nP[0] = new Pos(cur.r-1, cur.c);
            nP[1] = new Pos(cur.r, cur.c+1);
            nP[2] = new Pos(cur.r+1, cur.c);
            nP[3] = new Pos(cur.r, cur.c-1);

            for(int i = 0; i < 4; ++i)
            {
                if(nP[i].r < 0 || nP[i].r >= box.length
                || nP[i].c < 0 || nP[i].c >= box[0].length)
                    continue;

                if(visit[nP[i].r][nP[i].c] != -1)
                    continue;

                if(box[nP[i].r][nP[i].c] != 0)
                    continue;

                que.add(nP[i]);
                visit[nP[i].r][nP[i].c] = visit[cur.r][cur.c]+1;
                box[nP[i].r][nP[i].c] = 1;
                ans = Math.max(ans, visit[nP[i].r][nP[i].c]);
            }
        }

        boolean noZero = true;
        for(int i = 0; i < box.length; ++i)
        {
            for(int j = 0; j < box[0].length; ++j)
            {
                if(box[i][j] == 0)
                {
                    noZero = false;
                    break;
                }

            }
        }

        if(noZero)
            System.out.println(ans);
        else
            System.out.println(-1);
    }
}
