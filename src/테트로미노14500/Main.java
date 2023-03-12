package 테트로미노14500;
import java.io.*;
import java.util.*;

public class Main {

    static int rowSize;
    static int colSize;
    static int[][] paper;
    static int[] updown = {-1, 1, 0, 0};
    static int[] leftright = {0, 0, -1, 1};

    static int[][] polyomino = new int[4][2];
    static boolean[][] checked;

    static int max = Integer.MIN_VALUE;

    static int exception_case[][][] = {
            {{0,0},{0,-1},{0,1},{-1,0}},
            {{0,0},{-1,0},{1,0},{0,1}},
            {{0,0},{0,-1},{0,1},{1,0}},
            {{0,0},{-1,0},{1,0},{0,-1}}};

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input;
        input = br.readLine().split(" ");
        rowSize = Integer.parseInt(input[0]);
        colSize = Integer.parseInt(input[1]);

        paper = new int[rowSize][colSize];
        checked = new boolean[rowSize][colSize];

        for(int i = 0; i < rowSize; ++i)
        {
            input = br.readLine().split(" ");
            for(int j = 0; j < colSize; ++j)
            {
                paper[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i = 0; i < rowSize; ++i)
        {
            for(int j = 0; j < colSize; ++j)
            {
                if(false == checked[i][j])
                {
                    checked[i][j] = true;
                    assembly(i, j, 0);
                    checked[i][j] = false;
                }

                getExceptionCase(i, j);
            }


        }


        System.out.println(max);
    }

    static void assembly(int row, int col, int count)
    {
        if (count == 4)
        {
            max = Math.max(max, calculate());
            return;
        }

        int newRow;
        int newCol;

        polyomino[count][0] = row;
        polyomino[count][1] = col;

        for (int i = 0; i < 4; ++i)
        {
            newRow = row + updown[i];
            newCol = col + leftright[i];

            if(newRow < 0 || newRow >= rowSize || newCol < 0 || newCol >= colSize)
                continue;

            if (checked[newRow][newCol] == false)
            {
                checked[newRow][newCol] = true;
                assembly(newRow, newCol, count + 1);
                checked[newRow][newCol] = false;
            }

        }

    }

    static int calculate()
    {
        int result = 0;
        for (int i = 0; i < 4; ++i)
        {
            result += paper[polyomino[i][0]][polyomino[i][1]];
        }

        return result;
    }

    static void getExceptionCase(int x,int y){
        for(int i=0; i<4; i++){
            boolean ret = true;
            int sum = 0;

            for(int j=0; j<4; j++){
                int newRow = x + exception_case[i][j][0];
                int newCol = y + exception_case[i][j][1];

                if(newRow<0 || newCol<0 || newRow>=rowSize || newCol>=colSize){
                    ret = false;
                    break;
                }

                sum += paper[newRow][newCol];
            }

            if(ret)
                max = Math.max(max, sum);
        }
    }
}
