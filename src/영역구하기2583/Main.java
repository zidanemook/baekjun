package 영역구하기2583;

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
class Rect
{
    int lr;
    int lc;
    int rr;
    int rc;

    public Rect() {}

    public Rect(int leftRow, int leftCol, int rightRow, int rightCol) {
        this.lr = leftRow;
        this.lc = leftCol;
        this.rr = rightRow;
        this.rc = rightCol;
    }

    public boolean colPoint(Pos pos)
    {
        if(lr <= pos.r && rr > pos.r && lc <= pos.c && rc > pos.c)
            return true;

        return false;
    }
}

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        ArrayList<Rect> rects = new ArrayList<>();

        for(int i = 0; i < K; ++i)
        {
            input = br.readLine().split(" ");
            int lc = Integer.parseInt(input[0]);
            int lr = Integer.parseInt(input[1]);
            int rc = Integer.parseInt(input[2]);
            int rr = Integer.parseInt(input[3]);
            rects.add(new Rect(lr, lc, rr, rc));
        }

        int[][] map = new int[M][N];
        for(int i = 0; i < M; ++i)
        {
            for(int j = 0; j < N; ++j)
            {
                if(collide(rects, new Pos(i, j)))
                    map[i][j] = 1;
                else
                    map[i][j] = 0;
            }
        }
        boolean[][] visit = new boolean[M][N];

        int count = 0;
        ArrayList<Integer> area = new ArrayList<>();
        for(int i = 0; i < M; ++i)
        {
            for (int j = 0; j < N; ++j)
            {
                if(map[i][j] == 0 && visit[i][j] == false)
                {
                    area.add(bfs(new Pos(i, j) ,map, M, N, visit));
                    count++;
                }
            }
        }

        Collections.sort(area);

        System.out.println(count);
        area.stream().forEach(i-> System.out.print(i + " "));
    }

    private static int bfs(Pos start, int[][] map, int M, int N, boolean[][] visit)
    {
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        Queue<Pos> que = new LinkedList<>();
        que.add(start);
        visit[start.r][start.c] = true;

        int area = 1;

        while(que.isEmpty() == false)
        {
            Pos cur = que.poll();

            for(int i = 0; i < 4; ++i)
            {
                int r = cur.r + dir[i][0];
                int c = cur.c + dir[i][1];

                if(r < 0 || r >= M || c < 0 || c >= N)
                    continue;

                if(visit[r][c] == true)
                    continue;

                if(map[r][c] != 0)
                    continue;

                que.add(new Pos(r, c));
                visit[r][c] = true;
                area++;
            }
        }

        return area;
    }

    public static boolean collide(ArrayList<Rect> rects, Pos pos)
    {
        boolean ret = false;
        for(Rect ele : rects)
        {
            if(true == ele.colPoint(pos))
            {
                ret = true;
                break;
            }
        }

        return ret;
    }
}
