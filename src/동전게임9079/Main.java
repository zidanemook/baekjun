package 동전게임9079;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        //상태가 주어졌을때 숫자로 변환 H앞면 1, T뒷면 0 으로 가정
        int[] status = new int[T];
        String[] input;
        for(int i = 0; i < T; ++i)
        {
            for(int j = 0; j < 3; ++j)
            {
                input = br.readLine().split(" ");
                for(int k = 0; k < 3; ++k)
                {
                    if(input[k].equals("H"))
                    {
                        status[i] += 1 << (8-(j*3+k));
                    }
                }
            }
        }



        int[][] option =
                {{8, 7, 6}, //1행
                {5, 4, 3},  //2행
                {2, 1, 0},  //3행
                {8, 5, 2}, //1열
                {7, 4, 1}, //2열
                {6, 3, 0}, //3열
                {8, 4, 0}, //좌상 우하 대각선
                {6, 4, 2}};//좌하 우상 대각선

        int statuscopy = change(option[0], status[0]);


    }

    static void makeCase()
    {

    }
    static int change(int[] changeIdx, int stat)
    {
        int[] changer = {1, 2, 4, 8, 16, 32, 64, 128, 256};// ^ 연산으로 비트값 뒤집기 위함

        for(int i = 0; i < changeIdx.length; ++i)
        {
            stat ^= changer[changeIdx[i]];
        }

        return stat;
    }
}

