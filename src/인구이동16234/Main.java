package 인구이동16234;

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
    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);
        int R = Integer.parseInt(input[2]);

        int[][] board = new int[N][N];
        for(int i = 0; i < N; ++i)
        {
            input = br.readLine().split(" ");
            for(int j = 0; j < N; ++j)
            {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        boolean[][] visit = new boolean[N][N];
        ArrayList<Pos> unite = new ArrayList<>();//연합을 저장하기
        boolean moved = false;//인구이동 발생하였나
        int ans = 0;

        while(true)
        {
            for(int i = 0; i < N; ++i)
            {
                for(int j = 0; j < N; ++j)
                {
                    if(visit[i][j] == false)
                    {
                        bfs(new Pos(i, j) , board, N, L, R, visit, unite);//연합찾기

                        if(unite.size() > 1)
                        {
                            move(board, N, unite);//연합안에서 인구이동
                            moved = true;
                        }

                        unite.clear();
                    }
                }
            }

            for(int i = 0; i < N; ++i)
                Arrays.fill(visit[i], false);

            if(moved)
            {
                moved = false;
                ans++;
            }
            else
                break;
        }

        System.out.println(ans);
    }

    private static void bfs(Pos start, int[][] board, int N, int L, int R, boolean[][] visit, ArrayList<Pos> unite)
    {
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        Queue<Pos> que = new LinkedList<>();

        que.add(start);
        visit[start.r][start.c] = true;
        unite.add(new Pos(start.r, start.c));
        while(que.isEmpty() == false)
        {
            Pos cur = que.poll();

            for(int i = 0; i < 4; ++i)
            {
                int r = cur.r + dir[i][0];
                int c = cur.c + dir[i][1];

                if(r < 0 || r >= N || c < 0 || c >= N || visit[r][c]==true)
                    continue;

                int diff = Math.abs(board[cur.r][cur.c] - board[r][c]);//이동 조건 만족하였는지
                if(diff < L || diff > R)
                    continue;

                que.add(new Pos(r, c));
                visit[r][c] = true;
                unite.add(new Pos(r, c));
            }
        }

    }
    private static void move(int[][] board, int n, ArrayList<Pos> unite)
    {
        int avg = 0;
        for(Pos element : unite)
        {
            avg += board[element.r][element.c];
        }
        avg = avg / unite.size();

        for(Pos element : unite)
        {
            board[element.r][element.c] = avg;
        }
    }
}
