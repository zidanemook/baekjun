package 알파벳1987;

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
    static int ans = 0;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        String[][] board = new String[R][C];
        boolean[][] visit = new boolean[R][C];

        for(int i = 0; i < R; ++i)
        {
            input = br.readLine().split("");
            for(int j = 0; j < C; ++j)
            {
                board[i][j] = input[j];
            }
        }

        HashSet<String> hashSet = new HashSet<>();
        visit[0][0] = true;
        hashSet.add(board[0][0]);
        dfs(new Pos(0, 0), board, visit, hashSet, 1);

        System.out.println(ans);
    }

    private static void dfs(Pos pos, String[][] board, boolean[][] visit, HashSet<String> hashSet, int depth)
    {
        ans = Math.max(ans, depth);

        Pos[] newPos = new Pos[4];
        newPos[0] = new Pos(pos.r-1, pos.c);
        newPos[1] = new Pos(pos.r, pos.c+1);
        newPos[2] = new Pos(pos.r+1, pos.c);
        newPos[3] = new Pos(pos.r, pos.c-1);

        for(int i = 0; i < 4; ++i)
        {
            if(newPos[i].r < 0 || newPos[i].r >= board.length
                || newPos[i].c < 0 || newPos[i].c >= board[0].length)
                continue;

            if(visit[newPos[i].r][newPos[i].c] == true)
                continue;

            if(hashSet.contains(board[newPos[i].r][newPos[i].c]))
                continue;

            visit[newPos[i].r][newPos[i].c] = true;
            hashSet.add(board[newPos[i].r][newPos[i].c]);
            dfs(newPos[i], board, visit, hashSet, depth+1);
            hashSet.remove(board[newPos[i].r][newPos[i].c]);
            visit[newPos[i].r][newPos[i].c] = false;
        }
    }
}
