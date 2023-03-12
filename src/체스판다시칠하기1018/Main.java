package 체스판다시칠하기1018;

import java.io.*;
import java.util.*;

public class Main {

    static final int bsize = 8;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N,M;
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        Character[][] board = new Character[N][M];
        String temp;
        for(int i = 0; i < N; ++i)
        {
            temp = br.readLine();
            for(int j = 0; j < M; ++j)
            {
                board[i][j] = temp.charAt(j);
            }
        }

        int min = Integer.MAX_VALUE;

        //(0,0)이 White 되야한다고 가정후 Black, White 카운트, 행과 열의 합이 짝수인 칸이 white
        int evenWhite = 0;
        int evenBlack = 0;
        //(0,0)이 Black 되야한다고 가정후 Black, White 카운트, 행과 열의 합이 짝수인 칸이 black
        int oddWhite = 0;
        int oddBlack = 0;
        for(int i = 0; i <= N - bsize; ++i)
        {
            for(int j = 0; j <= M - bsize; ++j)
            {
                for(int k = i; k < i+bsize; k++)
                {
                    for(int l = j; l < j+bsize; ++l)
                    {
                        if((k-i+l-j) %2 == 0)//움직이는 8x8 안에서 0,0 부터 시작체크하도록함
                        {
                            if(board[k][l] == 'B')
                                evenWhite++;
                            else
                                oddBlack++;
                        }
                        else
                        {
                            if(board[k][l] == 'W')
                                evenBlack++;
                            else
                                oddWhite++;
                        }
                    }
                }

                //테스트케이스마다 카운트 한거중 작은거

                min = Math.min(min, Math.min(evenBlack + evenWhite, oddBlack + oddWhite));
                evenWhite = 0;
                evenBlack = 0;
                oddWhite = 0;
                oddBlack = 0;
            }
        }

        System.out.println(min);

    }

}
