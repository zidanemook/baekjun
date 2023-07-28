package 운동1956;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int v = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);

        int[][] dist = new int[v+1][v+1];
        int INF = 10000000;

        for (int i = 1; i <= v; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < e; i++) {
            input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            dist[a][b] = c;
        }

        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                for (int k = 1; k <= v; k++) {
                    if( dist[j][k] > dist[j][i] + dist[i][k])
                        dist[j][k] = dist[j][i] + dist[i][k];
                }
            }
        }

        int result = INF;
        for (int i = 1; i <= v; i++)
            for (int j = 1; j <= v; j++){
                if(i == j && dist[i][j] == 0)
                    continue;

                if (dist[i][j] != INF && dist[j][i] != INF){
                    if(i == j){
                        result = Math.min(result, dist[i][j]);
                    }else
                        result = Math.min(result, dist[i][j] + dist[j][i]);
                }

            }


        if (result == INF) System.out.println(-1);
        else System.out.println(result);
    }
}
