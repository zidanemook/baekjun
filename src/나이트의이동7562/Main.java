package 나이트의이동7562;

import java.io.*;
import java.util.*;

class Pos
{
    int x;
    int y;

    public Pos() {
    }

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean compare(Pos obj) {
        return (this.x == obj.x && this.y == obj.y);
    }
}

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        String[] input;
        int boardSize = 0;
        Pos start = new Pos();
        Pos end = new Pos();
        Pos cur = new Pos();
        Queue<Pos> que = new LinkedList<>();

        for(int i = 0; i < tc; ++i)
        {

            boardSize = Integer.parseInt(br.readLine());
            int[][] visit = new int[boardSize][boardSize];

            input = br.readLine().split(" ");
            start.x = Integer.parseInt(input[0]);
            start.y = Integer.parseInt(input[1]);

            input = br.readLine().split(" ");
            end.x = Integer.parseInt(input[0]);
            end.y = Integer.parseInt(input[1]);

            que.add(start);
            visit[start.x][start.y] = 1;

            while(start.compare(end)== false && que.isEmpty() == false)
            {
                cur = que.poll();

                if(AddNext(cur, end, boardSize, visit, que))
                {
                    break;
                }
            }

            System.out.println(visit[end.x][end.y]-1);
            que.clear();
        }

    }

    private static boolean AddNext(Pos cur, Pos end, int boardSize, int[][] visit, Queue<Pos> que)
    {
        int dir = 8;
        Pos[] newPos = new Pos[dir];
        newPos[0] = new Pos(cur.x-1, cur.y-2);  //upLeft
        newPos[1] = new Pos(cur.x+1, cur.y-2);  //upRight
        newPos[2] = new Pos(cur.x+2, cur.y-1);  //rightUp
        newPos[3] = new Pos(cur.x+2, cur.y+1);  //rightDown
        newPos[4] = new Pos(cur.x+1, cur.y+2);  //downRight
        newPos[5] = new Pos(cur.x-1, cur.y+2);  //downLeft
        newPos[6] = new Pos(cur.x-2, cur.y+1);  //leftDown
        newPos[7] = new Pos(cur.x-2, cur.y-1);  //leftUp

        for(int i = 0; i < dir; ++i)
        {
            if(newPos[i].compare(end))
            {
                visit[newPos[i].x][newPos[i].y] = visit[cur.x][cur.y]+1;
                return true;
            }


            if(newPos[i].x >= 0 && newPos[i].x < boardSize
                    && newPos[i].y >= 0 && newPos[i].y < boardSize
                    && visit[newPos[i].x][newPos[i].y] == 0)
            {
                que.add(newPos[i]);
                visit[newPos[i].x][newPos[i].y] = visit[cur.x][cur.y]+1;
            }
        }

        return false;
    }
}
