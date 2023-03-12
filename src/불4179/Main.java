package 불4179;

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
    static int testcode = 0;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        int [][] jmiro = new int[R][C];
        int [][] fmiro = new int[R][C];

        Queue<Pos> ji = new LinkedList<>();
        Queue<Pos> fire = new LinkedList<>();
        for(int i = 0; i < R; ++i)
        {
            input = br.readLine().split("");
            for(int j = 0; j < C; ++j)
            {
                if(input[j].equals("."))
                {
                    jmiro[i][j] = 0;
                    fmiro[i][j] = 0;
                }
                else if(input[j].equals("J"))
                {
                    jmiro[i][j] = 1;
                    ji.add(new Pos(i, j));
                }
                else if(input[j].equals("F"))
                {
                    fmiro[i][j] = 1;
                    fire.add(new Pos(i, j));
                }
                else if(input[j].equals("#"))
                {
                    jmiro[i][j] = -1;
                    fmiro[i][j] = -1;
                }

            }
        }

        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        boolean[][] visit = new boolean[R][C];

        //J 확산

        bfs(ji, R, C,jmiro, visit, dir);


        for(int i = 0; i < R; ++i)
            Arrays.fill(visit[i], false);

        //F 확산

        bfs(fire, R, C,fmiro, visit, dir);

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < R; ++i)
        {
            if(i == 0|| i == R-1)//윗변, 아랫변
            {
                for(int j = 0; j < C; ++j)
                {
                    if(jmiro[i][j] == -1 || jmiro[i][j] == 0)//벽은 갈 수 없는곳. 0 인곳은 완전히 막힌곳
                        continue;

                    if(fmiro[i][j] == 0 || (jmiro[i][j] < fmiro[i][j]))
                    {
                        ans = Math.min(ans, jmiro[i][j]);
                    }
                }
            }
            else
            {

                if(jmiro[i][0] != -1 && jmiro[i][0] != 0)//벽은 갈 수 없는곳. 0 인곳은 완전히 막힌곳
                {
                    if(fmiro[i][0] == 0 || (jmiro[i][0] < fmiro[i][0]))
                        ans = Math.min(ans, jmiro[i][0]);
                }

                if(jmiro[i][C-1] != -1 && jmiro[i][C-1] != 0)//벽은 갈 수 없는곳. 0 인곳은 완전히 막힌곳
                {
                    if(fmiro[i][C-1] == 0 || (jmiro[i][C-1] < fmiro[i][C-1]))
                        ans = Math.min(ans, jmiro[i][C-1]);
                }

            }

        }

        if(ans == Integer.MAX_VALUE)
            System.out.println("IMPOSSIBLE");
        else
            System.out.println(ans);

            System.out.println(testcode);
    }

    private static void bfs(Queue<Pos> que, int R, int C, int[][] miro, boolean[][] visit, int[][] dir)
    {
        for(Pos element: que)
        {
            visit[element.r][element.c] = true;
        }

        while(que.isEmpty() == false)
        {
            Pos cur = que.poll();

            for(int i = 0; i < 4; ++i)
            {
                int r = cur.r + dir[i][0];
                int c = cur.c + dir[i][1];

                if(r < 0 || r >= R || c < 0 || c >= C)
                    continue;

                if(miro[r][c] != 0)
                    continue;

                if(visit[r][c] == true)
                    continue;

                que.add(new Pos(r, c));
                miro[r][c] = miro[cur.r][cur.c] + 1;
                visit[r][c] = true;

                testcode++;
            }

        }

    }
}
