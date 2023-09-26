package 행렬1080;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] matA = new int[N][M];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split("");

            for (int j = 0; j < M; j++) {
                matA[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[][] matB = new int[N][M];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split("");

            for (int j = 0; j < M; j++) {
                matB[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[][] matC = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(matA[i][j] != matB[i][j])
                    matC[i][j] = 1;
            }
        }

        int answer = 0;
        for(int i = 0; i <= N-3; ++i)
        {
            for(int j = 0; j <= M-3; ++j)
            {
                if (matC[i][j] == 1) {
                    flip(matC, i, j);
                    answer++;
                }
            }
        }

        boolean check = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matC[i][j] != 0) check = false;
            }
        }

        if(check)
            System.out.println(answer);
        else
            System.out.println(-1);
    }

    public static void flip(int[][] matC, int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                matC[i][j] = 1 - matC[i][j];
            }
        }
    }
}
