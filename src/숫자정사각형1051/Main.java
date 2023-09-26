package 숫자정사각형1051;

import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;

    static int[][] map;

    static int answer = 1;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < N-1; i++) {
            for(int j = 0; j < M-1; j++)
            {
                find(i, j);
            }
        }

        System.out.println(answer);

    }

    public static int find(int sr, int sc)
    {
        int ret = 1;
        for (int i = sr+1; i < N; i++) {
            for (int j = sc+1; j < M; j++) {

                int er = i;
                int ec = j;

                if(er-sr != ec-sc)
                    continue;

                if(map[sr][sc] == map[sr][ec] && map[sr][sc] == map[er][sc] && map[er][sc] == map[er][ec])
                {
                    int temp = (er-sr+1) * (ec-sc+1);
                    answer = Math.max(answer, temp);
                }
            }
        }

        return ret;
    }
}
