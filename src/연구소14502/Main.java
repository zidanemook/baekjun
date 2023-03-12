package 연구소14502;

import java.io.*;
import java.util.*;

public class Main
{

    static int n;//행개수
    static int m;//열개수

    static int[][] map;
    static boolean[][] visit;

    static int[] wall = new int[3];//벽을 세울위치
    static int inputWall;//입력받은 벽 개수

    static int ans = 0;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n][m];
        visit = new boolean[n][m];

        inputWall = 0;
        for(int i = 0; i < n; ++i)
        {
            input = br.readLine().split(" ");
            for(int j = 0; j < m; ++j)
            {
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j] == 1)
                    inputWall++;
            }
        }

        dfs(0);

        System.out.println(ans);
    }

    public static void dfs(int depth)//완전탐색으로 벽을 배치
    {
        if(depth == 3)//벽 3개 배치하면 바이러스 퍼지도록 시뮬레이션
        {
            int vcnt = virusSimul(wall);
            int safecnt = m*n - vcnt - inputWall - 3;//전체 - 바이러스 - 입력받은벽 - 배치한벽
            ans = Math.max(ans, safecnt);
            return;
        }

        for(int i = 0; i < n*m; ++i)
        {
            int r = i/m;
            int c = i%m;
            if(visit[r][c]==false && map[r][c] == 0)
            {
                visit[r][c] = true;
                wall[depth] = i;
                dfs(depth+1);
                visit[r][c] = false;
            }

        }
    }

    private static int virusSimul(int[] wall)
    {
        int ret = 0;
        boolean[][] virVisit = new boolean[n][m];
        for(int i = 0;i < n; ++i)
        {
            for(int j = 0; j < m; ++j)
            {
                if(map[i][j] == 2)
                {
                    ret++;//시작지점 바이러스 카운트
                    ret += bfs(i, j, wall, virVisit);
                }
            }
        }


        return ret;
    }

    private static int bfs(int i, int j, int[] wall, boolean[][] virVisit)
    {
        int ret = 0;
        class Pos
        {
            int r;
            int c;

            public Pos() {}

            public Pos(int r, int c) {
                this.r = r;
                this.c = c;
            }

            boolean compare(Pos pos)
            {
                return (this.r == pos.r && this.c == pos.c);
            }
        }
        Pos start = new Pos(i, j);
        Queue<Pos> que = new LinkedList<>();

        que.add(start);
        visit[i][j] = true;
        Pos[] nextPos = new Pos[4];

        Pos[] addedWall = new Pos[3];
        for(int k = 0; k < addedWall.length; ++k)
        {
            addedWall[k] = new Pos(wall[k]/m, wall[k]%m);
        }


        while(que.isEmpty() == false)
        {
            Pos cur = que.poll();

            nextPos[0] = new Pos(cur.r-1, cur.c);
            nextPos[1] = new Pos(cur.r, cur.c+1);
            nextPos[2] = new Pos(cur.r+1, cur.c);
            nextPos[3] = new Pos(cur.r, cur.c-1);

            for(int k = 0; k < 4; ++k)
            {
                if(nextPos[k].compare(addedWall[0])
                        || nextPos[k].compare(addedWall[1])
                        || nextPos[k].compare(addedWall[2]))
                        continue;

                if(nextPos[k].r >= 0 && nextPos[k].r < n
                        && nextPos[k].c >= 0 && nextPos[k].c < m
                        && virVisit[nextPos[k].r][nextPos[k].c] == false
                        && map[nextPos[k].r][nextPos[k].c] == 0)
                {
                    virVisit[nextPos[k].r][nextPos[k].c] = true;

                    que.add(nextPos[k]);
                    ret++;
                }
            }

        }

        return ret;
    }

}
