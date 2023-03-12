package 봄버맨16918;

import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);
        int N = Integer.parseInt(input[2]);

        int[][] board = new int[R][C];

        for(int i = 0; i < R; ++i)
        {
            input = br.readLine().split("");
            for(int j = 0; j < C; ++j)
            {
                if(input[j].equals("."))
                    board[i][j] = 0;
                else
                    board[i][j] = 3;
            }
        }

        boolean install = false;
        int time = 1;
        while(N+1 > time)
        {
            if(time >= 2)
                install = !install;

            updateBoard(board, R, C, install);

            time++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < R; ++i)
        {
            for(int j = 0; j < C; ++j)
            {
                if(board[i][j] == 0)
                    sb.append(".");
                else
                    sb.append("O");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void updateBoard(int[][] board, int R, int C, boolean install)
    {
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for(int i = 0; i < R; ++i)
        {
            for(int j = 0; j < C; ++j)
            {
                if(board[i][j] == 1)//pang!
                {
                    board[i][j] = 0;
                    for(int k = 0; k < 4; ++k)
                    {
                        int r = i+dir[k][0];
                        int c = j+dir[k][1];
                        if(r >= 0 && r < R && c >= 0 && c < C
                        && board[r][c] != 1)//같은시간에 터지는 폭탄은 각각 터트린다
                        {
                            board[r][c] = 0;
                        }
                    }
                }
                else if(board[i][j] > 1)
                    board[i][j]--;

                if(install)
                {
                    if(board[i][j] == 0)
                        board[i][j] = 3;
                }
            }
        }
    }
}
