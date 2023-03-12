package 오목2615;

import java.io.*;
import java.util.*;

public class Main {

    static class Pos
    {
        public int row;
        public int col;

        public Pos (int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object obj) {
            return (this.row == ((Pos)obj).row && this.col == ((Pos)obj).col);
        }
    }

    static int[][] pan;
    static boolean[][] checked;

    static Pos[] answer = new Pos[4];

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        pan = new int[19][19];
        checked = new boolean[19][19];

        for(int i = 0; i < 4; ++i)
        {
            answer[i] = new Pos(0,0);
        }


        String[] input;
        for(int i = 0; i < 19; ++i)
        {
            input = br.readLine().split(" ");
            for(int j = 0; j < 19; ++j)
            {
                pan[i][j] = Integer.parseInt(input[j]);
            }
        }

        int color = 0;
        for(int i = 0; i < 19; ++i)
        {
            for(int j = 0; j < 19; ++j)
            {
                if(pan[i][j] != 0 && (checked[i][j] == false))
                {
                    color = bfs(i, j);
                    if(color != 0)
                        break;
                }
            }
            if(color != 0)
                break;
        }

        System.out.println(color);

        if(color != 0)
        {
            for(int i = 0; i < 4; ++i)
            {
                if(answer[i].row != -1)
                    System.out.println((answer[i].row + 1) + " " + (answer[i].col + 1));
            }

        }

    }

    static int bfs(int row, int col)
    {
        int ret = 0;

        int color = pan[row][col];

        Queue<Pos> que = new LinkedList<>();

        Pos[] preCheck = new Pos[4];
        for(int i = 0; i < 4; ++i)
        {
            preCheck[i] = new Pos(row, col);
        }
        que.add(preCheck[0]);
        checked[row][col] = true;

        Pos cur;


        //연결 개수 카운트
        int[] lenthCount = {1, 1, 1, 1};//위아래 대각선 // 오른쪽으로 오르는 대각선// x축 대각선// 오른쪽 하강 대각선


        while(que.isEmpty() == false)
        {
            cur = que.poll();

            //12 시 방향
            if(
                    (cur.row-1 >= 0) &&
                            pan[cur.row-1][cur.col] == color &&
                            checked[cur.row-1][cur.col] == false)
            {
                Pos newPos = new Pos(cur.row-1, cur.col);
                que.add(newPos);
                checked[cur.row-1][cur.col] = true;

                if(lenthCount[0] > 1 && preCheck[0].equals(cur) == false)
                    lenthCount[0] = 2;

                preCheck[0] = newPos;

                lenthCount[0]++;
                if(lenthCount[0] == 5)
                {
                    answer[0].row = cur.row-1;
                    answer[0].col = cur.col;
                }

            }
            //6시 방향
            if(
                    (cur.row+1 < 19) &&
                            pan[cur.row+1][cur.col] == color &&
                            checked[cur.row+1][cur.col] == false )
            {
                Pos newPos = new Pos(cur.row+1, cur.col);
                que.add(newPos);
                checked[cur.row+1][cur.col] = true;
                if(lenthCount[0] > 1 && preCheck[0].equals(cur) == false)
                    lenthCount[0] = 2;

                preCheck[0] = newPos;

                lenthCount[0]++;

                if(lenthCount[0] == 5 && (cur.row-3 >= 0))
                {
                    answer[0].row = cur.row-3;
                    answer[0].col = cur.col;
                }
            }

            //1:30 방향
            if(
                    (cur.row-1 >= 0) &&
                            (cur.col+1 < 19) &&
                            pan[cur.row-1][cur.col+1] == color &&
                            checked[cur.row-1][cur.col+1] == false)
            {
                Pos newPos = new Pos(cur.row-1, cur.col+1);
                que.add(newPos);
                checked[cur.row-1][cur.col+1] = true;

                if(lenthCount[1] > 1 && preCheck[1].equals(cur) == false)
                    lenthCount[1] = 2;

                preCheck[1] = newPos;

                lenthCount[1]++;

                if(lenthCount[1] == 5 && (19 > cur.row+3) && (cur.col-3 >= 0))
                {
                    answer[1].row = cur.row+3;
                    answer[1].col = cur.col-3;
                }
            }
            //7:30
            if((cur.row+1 < 19) &&
                    (cur.col-1 >= 0) &&
                    pan[cur.row+1][cur.col-1] == color &&
                    checked[cur.row+1][cur.col-1] == false)
            {
                Pos newPos = new Pos(cur.row+1, cur.col-1);
                que.add(newPos);
                checked[cur.row+1][cur.col-1] = true;

                if(lenthCount[1] > 1 && preCheck[1].equals(cur) == false)
                    lenthCount[1] = 2;

                preCheck[1] = newPos;

                lenthCount[1]++;

                if(lenthCount[1] == 5)
                {
                    answer[1].row = cur.row+1;
                    answer[1].col = cur.col-1;
                }
            }

            //3시 방향
            if((cur.col+1 < 19) &&
                    pan[cur.row][cur.col+1] == color &&
                    checked[cur.row][cur.col+1] == false)
            {
                Pos newPos = new Pos(cur.row, cur.col+1);
                que.add(newPos);
                checked[cur.row][cur.col+1] = true;

                if(lenthCount[2] > 1 && preCheck[2].equals(cur) == false)
                    lenthCount[2] = 2;

                preCheck[2] = newPos;

                lenthCount[2]++;

                if(lenthCount[2] == 5 && (cur.col-3 >= 0))
                {
                    answer[2].row = cur.row;
                    answer[2].col = cur.col-3;
                }
            }
            //9시 방향
            if((cur.col-1 >= 0) &&
                    pan[cur.row][cur.col-1] == color &&
                    checked[cur.row][cur.col-1] == false)
            {
                Pos newPos = new Pos(cur.row, cur.col-1);
                que.add(newPos);
                checked[cur.row][cur.col-1] = true;

                if(lenthCount[2] > 1 && preCheck[2].equals(cur) == false)
                    lenthCount[2] = 2;

                preCheck[2] = newPos;

                lenthCount[2]++;

                if(lenthCount[2] == 5)
                {
                    answer[2].row = cur.row;
                    answer[2].col = cur.col-1;
                }
            }
            //4:30
            if((cur.row+1 < 19) &&
                    (cur.col+1 < 19) &&
                    pan[cur.row+1][cur.col+1] == color &&
                    checked[cur.row+1][cur.col+1] == false)
            {
                Pos newPos = new Pos(cur.row+1, cur.col+1);
                que.add(newPos);
                checked[cur.row+1][cur.col+1] = true;

                if(lenthCount[3] > 1 && preCheck[3].equals(cur) == false)
                    lenthCount[3] = 2;

                preCheck[3] = newPos;

                lenthCount[3]++;

                if(lenthCount[3] == 5 && (cur.row-3 >=0) && (cur.col-3 >=0))
                {
                    answer[3].row = cur.row-3;
                    answer[3].col = cur.col-3;
                }
            }
            //10:30
            if((cur.row-1 >= 0) &&
                    (cur.col-1 >= 0) &&
                    pan[cur.row-1][cur.col-1] == color &&
                    checked[cur.row-1][cur.col-1] == false)
            {
                Pos newPos = new Pos(cur.row-1, cur.col-1);
                que.add(newPos);
                checked[cur.row-1][cur.col-1] = true;

                if(lenthCount[3] > 1 && preCheck[3].equals(cur) == false)
                    lenthCount[3] = 2;

                preCheck[3] = newPos;

                lenthCount[3]++;

                if(lenthCount[3] == 5)
                {
                    answer[3].row = cur.row-1;
                    answer[3].col = cur.col-1;
                }
            }

        }

        for(int i = 0; i < 4; ++i)
        {
            if(lenthCount[i] == 5)
            {
                ret = color;
            }
            else
            {
                answer[i].row = -1;
                answer[i].col = -1;
            }

        }

        return ret;
    }

}
