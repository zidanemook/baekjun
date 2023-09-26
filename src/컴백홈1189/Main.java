package 컴백홈1189;

import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static int R;
    static int C;
    static int K;

    static boolean[][] visit;
    static int answer = 0;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {

            String[] input = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                if(input[j].equals(".")){
                    map[i][j] = 0;
                }else{
                    map[i][j] = 1;
                }
            }
        }

        visit[R-1][0] = true;
        dfs(1, R-1, 0);

        System.out.println(answer);

    }

    public static void dfs(int depth, int sr, int sc){

        if(depth >= K )
        {
            if(sr == 0 && sc == C-1)
                answer++;
            return;
        }

        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int i = 0; i < 4; i++) {

            int nr = sr + dir[i][0];
            int nc = sc + dir[i][1];

            if(nr < 0 || nr >= R || nc < 0 || nc >= C)
                continue;

            if(map[nr][nc] == 1)
                continue;

            if(visit[nr][nc])
                continue;

            visit[nr][nc] = true;
            dfs(depth+1, nr, nc);
            visit[nr][nc] = false;
        }

    }
}
