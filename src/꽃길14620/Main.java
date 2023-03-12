package 꽃길14620;

import java.io.*;
import java.util.*;

class Flower
{
    int row;
    int column;

    int cost;
    public Flower(int row, int column, int cost) {
        this.row = row;
        this.column = column;
        this.cost = cost;
    }
}

public class Main {

    static final int fsize = 3;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        int[][] land = new int[size][size];
        String[] row;

        for(int i = 0; i < size; ++i)
        {
            row = br.readLine().split(" ");
            for(int j = 0; j < size; ++j)
            {
                land[i][j] = Integer.parseInt(row[j]);
            }
        }

        ArrayList<ArrayList<Integer>> rowCase = new ArrayList<>();

        int idx = 0;
        while(idx < size-2)
        {
            for(int i = idx; i < fsize+idx; ++i)
            {
                if(i == idx)
                {
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    rowCase.add(tmp);
                }
                else
                {
                    rowCase.get(rowCase.size()-1).add(i);
                }
            }
            idx++;
        }

        ArrayList<Flower> flowers = new ArrayList<>();//꽃 땅사용료, 위치

        for(int i = 1; i < size-1; ++i)
        {
            for(int j = 0; j < rowCase.size(); ++j)
            {
                ArrayList<Integer> tmp = rowCase.get(j);
                int costOfFlower = 0;
                for(int k = 0; k < tmp.size(); ++k)//꽃의 좌중우 사용료
                {
                    costOfFlower += land[i][tmp.get(k)];
                    if(k == 1)
                    {
                        costOfFlower += land[i-1][tmp.get(k)];//꽃의 상 사용료
                        costOfFlower += land[i+1][tmp.get(k)];//꽃의 하 사용료
                    }
                }

                flowers.add(new Flower(i, tmp.get(1), costOfFlower));
            }
        }

        boolean[] visited = new boolean[flowers.size()];
        int[] arr = new int[fsize];
        int answer = 0;
        answer = search(0, flowers, arr, visited);

        System.out.println(answer);

    }

    static int search(int level, ArrayList<Flower> flowers, int[] arr, boolean[] visited)
    {
        if(level == fsize)
        {
            int sum = 0;
            for(int i = 0; i < arr.length; ++i)
            {
                sum += flowers.get(arr[i]).cost;
            }

            return sum;
        }

        int result = Integer.MAX_VALUE;
        for(int i = arr[level==0 ? 0 : level-1]; i < flowers.size(); ++i)
        {
            if(visited[i] == false && false == collisionTest(arr, level, i, flowers))
            {
                visited[i] = true;
                arr[level] = i;
                result = Math.min(result, search(level+1, flowers, arr, visited));
                visited[i] = false;
            }
        }

        return result;
    }

    static boolean collisionTest(int[] arr, int level, int idx, ArrayList<Flower> flowers)
    {
        class Position
        {
            int row;
            int column;

            public Position(int row, int column) {
                this.row = row;
                this.column = column;
            }

            boolean compare(Position p)
            {
                if(this.row == p.row && this.column == p.column)
                    return true;

                return false;
            }

        }

        boolean result = false;
        Flower second = flowers.get(idx);
        ArrayList<Position> pos2 = new ArrayList<>();
        pos2.add(new Position(second.row, second.column));
        pos2.add(new Position(second.row-1, second.column));
        pos2.add(new Position(second.row+1, second.column));
        pos2.add(new Position(second.row, second.column-1));
        pos2.add(new Position(second.row, second.column+1));

        Flower first;
        for(int i = 0; i < level; ++i)
        {
            if(arr[i] == idx)
                continue;
            first = flowers.get(arr[i]);

            ArrayList<Position> pos1 = new ArrayList<>();
            pos1.add(new Position(first.row, first.column));//중심
            pos1.add(new Position(first.row-1, first.column));//상
            pos1.add(new Position(first.row+1, first.column));//하
            pos1.add(new Position(first.row, first.column-1));//좌
            pos1.add(new Position(first.row, first.column+1));//우

            for(int j = 0; j < pos1.size(); ++j)
            {
                for(int k = 0; k < pos2.size(); ++k)
                {
                    if(true == pos1.get(j).compare(pos2.get(k)))
                    {
                        result = true;
                        break;
                    }
                }
                if(result)
                    break;
            }
        }

        return result;
    }
}
