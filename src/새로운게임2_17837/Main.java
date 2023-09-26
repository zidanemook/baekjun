package 새로운게임2_17837;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());//체스판 크기
        int K = Integer.parseInt(st.nextToken());//말의 개수

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] mal = new int[K][3];

        for(int i = 0;i < K; ++i)
        {
            st = new StringTokenizer(br.readLine(), " ");
            mal[i][0] = Integer.parseInt(st.nextToken());
            mal[i][1] = Integer.parseInt(st.nextToken());
            mal[i][2] = Integer.parseInt(st.nextToken());
        }

        while(true)
        {

        }
    }

}
