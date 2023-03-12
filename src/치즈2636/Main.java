package 치즈2636;

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

        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        int[][] board = new int[R][C];

        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        int preLeft = 0;
        for(int i = 0; i < R; ++i)
        {
            input = br.readLine().split(" ");
            for(int j = 0;j < C; ++j)
            {
                board[i][j] = Integer.parseInt(input[j]);
                if(board[i][j] == 0)
                    board[i][j] = -1;//진공상태로 만들기
                else
                    preLeft++;
            }
        }

        boolean[][] visit = new boolean[R][C];
        int time = 0;
        int left = 0;

        while(true)
        {
            for(int i = 0; i < R; ++i)
                Arrays.fill(visit[i], false);

            for(int i = 0; i < R; ++i)
            {
                for(int j = 0;j < C; ++j)
                {
                    if(board[i][j] == 0)
                        board[i][j] = -1;//진공상태로 만들기
                }
            }
            //공기채우기 색칠하기
            bfs(new Pos(0, 0), R, C, board, visit, dir);

            for(int i = 0; i < R; ++i)
                Arrays.fill(visit[i], false);

            time++;

            //치즈녹이면서 개수파악하기 //주변 칸이 0이고 visit 하지 않았으면 공기와 접한다
            left = cheese(board, R, C, visit, dir);

            if(left == 0)
                break;

            preLeft = left;
        }
        System.out.println(time);
        System.out.println(preLeft);
    }

    private static int cheese(int[][] board, int R, int C, boolean[][] visit, int[][] dir)//남은 치즈 반환
    {
        int ret = 0;
        for(int i = 0; i < R; ++i)
        {
            for(int j = 0;j < C; ++j)
            {
                if(board[i][j] == 1 && visit[i][j] == false)
                {
                    for(int k = 0; k < 4; ++k)
                    {
                        int r = i+dir[k][0];
                        int c = j+dir[k][1];

                        if(r >= 0 && r < R && c >= 0 && c < C && board[r][c]==0 && visit[r][c] == false)
                        {
                            board[i][j] = 0;
                            visit[i][j] = true;
                            break;
                        }
                    }
                    if(board[i][j] == 1)
                        ret++;
                }

            }
        }

        return ret;
    }

    private static void bfs(Pos start, int R, int C, int[][] board, boolean[][] visit, int[][] dir)
    {
        Queue<Pos> que = new LinkedList<>();
        que.add(start);
        visit[start.r][start.c] = true;
        board[start.r][start.c] = 0;

        while(que.isEmpty() == false)
        {
            Pos cur = que.poll();

            for(int i = 0; i < 4; ++i)
            {
                int r = cur.r + dir[i][0];
                int c = cur.c + dir[i][1];

                if(r >= 0 && r < R && c >= 0 && c <C && board[r][c]==-1)
                {
                    que.add(new Pos(r, c));
                    visit[r][c] = true;
                    board[r][c] = 0;
                }
            }
        }
    }
}
