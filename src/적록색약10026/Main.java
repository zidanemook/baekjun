package 적록색약10026;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[][] board = new String[n][n];

        String[] input;
        for(int i = 0; i < n; ++i)
        {
            input = br.readLine().split("");

            for(int j = 0; j < n; ++j)
            {
                board[i][j] = input[j];
            }
        }

        boolean[][] visit = new boolean[n][n];
        int ans = 0;
        for(int i = 0; i < n; ++i)
        {
            for(int j = 0; j < n; ++j)
            {
                if(visit[i][j] == false)
                {
                    dfs(i, j, visit, board);
                    ans++;
                }
            }
        }

        System.out.print(ans + " ");
        ans = 0;

        for(int i = 0; i < n; ++i)
        {
            Arrays.fill(visit[i], false);
        }

        for(int i = 0; i < n; ++i)
        {
            for(int j = 0; j < n; ++j)
            {
                if(visit[i][j] == false)
                {
                    visit[i][j] = true;
                    dfs(i, j, visit, board);
                    ans++;
                }
            }
        }

        System.out.println(ans);


    }

    private static void dfs(int i, int j, boolean[][] visit, String[][] board)
    {
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

        Stack<Pos> stack = new Stack<>();

        Pos start = new Pos();
        start.r = i;
        start.c = j;

        stack.push(start);
        visit[i][j] = true;

        String startColor = board[i][j];

        while(stack.isEmpty() == false)
        {
            Pos cur = stack.peek();
            Pos[] newPos = new Pos[4];
            newPos[0] = new Pos(cur.r-1, cur.c);//up
            newPos[1] = new Pos(cur.r, cur.c+1);//right
            newPos[2] = new Pos(cur.r+1, cur.c);//down
            newPos[3] = new Pos(cur.r, cur.c-1);//left

            boolean nowhereToGo = true;
            for(int k = 0; k < 4; ++k)
            {
                if(newPos[k].r >= 0 && newPos[k].r < board.length
                && newPos[k].c >= 0 && newPos[k].c < board.length
                && startColor.equals(board[newPos[k].r][newPos[k].c])
                && visit[newPos[k].r][newPos[k].c] == false)
                {
                    visit[newPos[k].r][newPos[k].c] = true;
                    stack.push(newPos[k]);
                    nowhereToGo = false;
                    if(board[newPos[k].r][newPos[k].c].equals("R"))
                        board[newPos[k].r][newPos[k].c] = "G";
                    break;
                }
            }
            if(nowhereToGo)
                stack.pop();
        }

        if(board[start.r][start.c].equals("R"))
            board[start.r][start.c] = "G";
    }
}
