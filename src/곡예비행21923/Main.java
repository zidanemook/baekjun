package 곡예비행21923;

import java.io.*;
import java.util.*;

public class Main {

    static final int INF = (int)1e9;
    static final int NM = 1005;

    static int[][][] d;
    static int[][] map;

    static int n;

    static int m;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[NM][NM];

        for (int i = 1; i <= n; i++) {
            input = br.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(input[j-1]);
            }
        }

        d = new int[NM][NM][2];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                d[i][j][0] = d[i][j][1] = -INF;
            }
        }
        d[n][1][0] = map[n][1];

        System.out.println(solve(n, m, 1));
    }

    public static int solve(int i, int j, int dir){
        if(i < 1 || i > n || j < 1 || j > m) return -INF;
        if(d[i][j][dir] != -INF) return d[i][j][dir];

        if(dir == 0){
            d[i][j][dir] = Math.max(solve(i+1, j, dir), solve(i, j-1, dir))+map[i][j];
        }else{
            d[i][j][dir] = Math.max(solve(i-1, j, dir), solve(i, j-1, dir))+map[i][j];
            d[i][j][dir] = Math.max(d[i][j][dir], solve(i, j, 0) + map[i][j]);
        }

        return d[i][j][dir];
    }
}
