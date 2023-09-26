package 배열복원하기16967;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[][] matA = new int[H][W];
        int[][] matB = new int[H+X][W+Y];

        for (int i = 0; i < (H + X); i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < (W + Y); j++) {
                matB[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < (H + X); i++) {
            for (int j = 0; j < (W + Y); j++) {
                if(i < X && j < W || i <H && j < Y){
                    matA[i][j] = matB[i][j];
                }else if(i >= X && j >= W || i >= H && j >= Y){
                    matA[i-X][j-Y] = matB[i][j];
                }
            }
        }

        for(int i=X; i<H; i++) {
            for(int j=Y; j<W; j++) {
                matA[i][j] = matB[i][j] - matA[i-X][j-Y];
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(j != W-1)
                    System.out.print(matA[i][j] + " ");
                else
                    System.out.print(matA[i][j]);
            }
            System.out.println();
        }
    }
}
