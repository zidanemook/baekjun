package 공주님을구해라;


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
        int T = Integer.parseInt(input[2]);

        int[][] castle = new int[N][M];

        for(int i = 0; i < N; ++i)
        {
            input = br.readLine().split(" ");
            for(int j = 0; j < M; ++j)
            {
                castle[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int[][] visit = new int[N][M];
        for(int i = 0; i < N; ++i)
        {
            Arrays.fill(visit[i], -1);
        }

        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, bfs(new Pos(0, 0), N, M, T, castle, visit, dir, true));

        for(int i = 0; i < N; ++i)
        {
            Arrays.fill(visit[i], -1);
        }

        ans = Math.min(ans, bfs(new Pos(0, 0), N, M, T, castle, visit, dir, false));

        if(Integer.MAX_VALUE == ans)
            System.out.println("Fail");
        else
            System.out.println(ans);
    }

    private static int bfs(Pos start, int N, int M, int T, int[][] castle, int[][] visit, int[][] dir, boolean getGram)
    {
        Queue<Pos> que = new LinkedList<>();
        que.add(start);
        visit[start.r][start.c] = 0;
        castle[start.r][start.c] = 0;

        boolean gram = false;
        boolean princess = false;
        Pos end = new Pos(N-1, M-1);

        while(que.isEmpty() == false)
        {
            Pos cur = que.poll();

            for(int i = 0; i < 4; ++i)
            {
                int r = cur.r + dir[i][0];
                int c = cur.c + dir[i][1];

                if(r < 0 || r >= N || c < 0 || c >= M || visit[r][c] != -1)
                    continue;

                if(!gram && castle[r][c]==1)
                    continue;

                if(end.r == r && end.c == c)
                {
                    princess = true;
                }

                if(getGram && castle[r][c]==2)//그람을 가질것인지 true 이면, 그람 찾으면 그람에서 시작하기
                {
                    gram = true;
                    que.clear();
                    que.add(new Pos(r,c));
                    int temp = visit[cur.r][cur.c]+1;
                    for(int j = 0; j < N; ++j)
                    {
                        Arrays.fill(visit[j], -1);
                    }
                    visit[r][c] = temp;
                    break;
                }

                que.add(new Pos(r, c));
                visit[r][c] = visit[cur.r][cur.c]+1;

            }
        }

        if(T < visit[end.r][end.c] || !princess)
            return Integer.MAX_VALUE;
        else
            return visit[end.r][end.c];

    }
}
