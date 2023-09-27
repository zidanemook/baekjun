package 마법사상어와토네이도20057;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cr = N/2;
        int cc = N/2;

        int len = 1;

        int dirc = -1;
        int dirr = 1;

        int[][] lspr = {{-2, 0, 2}, {-1, -1, 10}, {-1, 0, 7}, { -1, 1, 1}, {0, -2, 5}, {1, -1, 10}, {1, 0, 7}, {1, 1, 1}, {2, 0, 2}};
        int[][] rspr = {{-2, 0, 2}, {-1, -1, 1}, {-1, 0, 7}, { -1, 1, 10}, {0, 2, 5}, {1, -1, 1}, {1, 0, 7}, {1, 1, 10}, {2, 0, 2}};
        int[][] uspr = {{-2, 0, 5}, {-1, -1, 10}, {-1, 1, 10}, {0, -2, 2}, {0, -1, 7}, {0, 1, 7}, {0, 2, 2}, {1, -1, 1}, {1, 1, 1}};
        int[][] dspr = {{-1, -1, 1}, {-1, 1, 1}, {0, -2, 2}, {0, -1, 7}, {0, 1, 7}, {0, 2, 2}, {1, -1, 10}, {1, 1, 10}, {2, 0, 5}};

        int answer = 0;

        boolean exit = false;
        while(true)
        {
            int[][] spr = null;

            if(dirc < 0)
                spr = lspr;//왼쪽 퍼뜨리기
            else
                spr = rspr;//오른쪽 퍼뜨리기

            for (int i = 0; i < len; i++) {
                cc = cc + dirc;

                if(cc < 0 || cc >= N)
                {
                    exit = true;
                    break;
                }

                int sand = map[cr][cc];

                //퍼뜨리기
                for (int j = 0; j < 9; j++) {

                    int nr = cr + spr[j][0];
                    int nc = cc + spr[j][1];
                    int move = map[cr][cc] * spr[j][2] / 100;

                    if(nr < 0 || nr >= N || nc < 0 || nc >= N)
                        answer += move;
                    else
                        map[nr][nc] += move;

                    sand -= move;
                }

                int nc = cc+dirc;
                if(nc < 0 || nc >= N)
                    answer += sand;
                else
                    map[cr][nc] += sand;

                map[cr][cc] = 0;
            }



            if(exit) break;
            dirc*=-1;

            if(dirr < 0)
                spr = uspr;
            else
                spr = dspr;

            for (int i = 0; i < len; i++) {
                cr = cr + dirr;

                if(cr < 0 || cr >= N)
                {
                    exit = true;
                    break;
                }

                int sand = map[cr][cc];

                for (int j = 0; j < 9; j++) {

                    int nr = cr + spr[j][0];
                    int nc = cc + spr[j][1];
                    int move = map[cr][cc] * spr[j][2] / 100;

                    if(nr < 0 || nr >= N || nc < 0 || nc >= N)
                        answer += move;
                    else
                        map[nr][nc] += move;

                    sand -= move;
                }

                //알파에 옮기기
                int nr = cr+dirr;
                if(nr < 0 || nr >= N)
                    answer += sand;
                else
                    map[nr][cc] += sand;

                map[cr][cc] = 0;
            }

            if(exit) break;
            dirr*=-1;
            len++;
        }

        System.out.println(answer);
    }
}
