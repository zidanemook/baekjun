package 주지수15724;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] map = new int[n+1][m+1];

        for (int i = 1; i < n+1; i++) {
            input = br.readLine().split(" ");
            map[i] = new int[m+1];
            for (int j = 1; j < m+1; j++) {
                map[i][j] = map[i][j-1] + Integer.parseInt(input[j-1]);
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if(i>1){
                    map[i][j] += map[i-1][j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            input = br.readLine().split(" ");
            int[] start = new int[2];
            int[] end = new int[2];
            start[0] = Integer.parseInt(input[0]);
            start[1] = Integer.parseInt(input[1]);
            end[0] = Integer.parseInt(input[2]);
            end[1] = Integer.parseInt(input[3]);

            int sum = 0;

            sum = map[end[0]][end[1]] - map[start[0]-1][end[1]] - map[end[0]][start[1]-1]+map[start[0]-1][start[1]-1];

            sb.append(sum);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
