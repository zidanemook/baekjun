package 떡돌리기20007;

import java.io.*;
import java.util.*;

public class Main {

    static int INF = 10000;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);
        int y = Integer.parseInt(input[3]);

        int[][] map = new int [n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], INF);
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);

            map[a][b] = cost;
            map[b][a] = cost;
            map[a][a] = 0;
            map[b][b] = 0;
        }

        boolean[] visit = new boolean[n];
        int d[] = new int[n];

        djik(y, map, d, visit);

        Arrays.sort(d);

        for (int i = 0; i < d.length; i++) {
            d[i]*=2;
            if(d[i] > x){
                System.out.println(-1);
                return;
            }
        }

        int day = 0, idx = 0, tmp = 0;
        while(idx < n) {

            while(idx < n && tmp + d[idx] <= x) {
                tmp += d[idx++];
            }

            tmp = 0;
            day++;
        }

        System.out.println(day);
    }

    public static int getSmallIndex(int n, int d[], boolean[] visit){
        int min = INF;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if(d[i] < min && !visit[i]){
                min = d[i];
                index = i;
            }
        }
        return index;
    }

    public static void djik(int start, int[][] map, int d[], boolean[] visit){

        for (int i = 0; i < map.length; i++) {
             d[i] = map[start][i];
        }

        visit[start] = true;
        for (int i = 0; i < map.length - 2; i++) {
            int cur = getSmallIndex(map.length, d, visit);
            visit[cur] = true;

            for (int j = 0; j < map[cur].length; j++) {
                if(visit[j] == false){
                    if(d[cur] + map[cur][j] < d[j]){
                        d[j] = d[cur] + map[cur][j];
                    }
                }
            }

        }
    }
}
