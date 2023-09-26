package 미세먼지안녕17144;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] map = new int[R][C];
        int[][] cleaner = new int[2][2];
        int idOfCleaner = 0;

        for(int i = 0; i < R; ++i)
        {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < C; ++j)
            {
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;

                if(-1 == temp)
                {
                    cleaner[idOfCleaner][0] = i;
                    cleaner[idOfCleaner][1] = j;
                    idOfCleaner++;
                }

            }
        }

        int dir[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for(int i = 0; i < T; ++i)
        {
            int[][] mungimap = new int[R][C];

            //먼지 확산
            for(int j = 0; j < R; ++j)
            {
                for(int k = 0; k < C; ++k)
                {
                    if(map[j][k] > 0 )
                    {
                        //4방향
                        int mungisum = 0;
                        for(int l = 0; l < 4; ++l)
                        {
                            int nr = j + dir[l][0];
                            int nc = k + dir[l][1];

                            if(0 > nr || nr >= R || 0 > nc || nc >= C)//범위를 벗어남
                                continue;
                            if(map[nr][nc] == -1)//청정기 제외
                                continue;

                            mungimap[nr][nc] += map[j][k]/5;
                            mungisum += map[j][k]/5;
                        }

                        map[j][k] -= mungisum;//확산된 만큼 빼기
                    }
                }
            }
            //확산된먼지 맵에적용
            for(int j = 0; j < R; ++j) {
                for (int k = 0; k < C; ++k) {
                    map[j][k] += mungimap[j][k];
                }
            }

            //공기청정기 바람
            //위쪽 반시계
            Deque<Integer> dque = new LinkedList<>();
            int sr = cleaner[0][0];
            int sc = cleaner[0][1]+1;
            dque.add(map[sr][sc]);
            map[sr][sc] = 0;
            while(true)
            {
                if(sr == cleaner[0][0] && sc != C-1)
                    sc++;
                else if(sc == C-1 && sr != 0)
                    sr--;
                else if(sr == 0 && sc != 0)
                    sc--;
                else if(sr != cleaner[0][0]-1 && sc == 0)
                    sr++;
                else
                    break;

                dque.addLast(map[sr][sc]);
                map[sr][sc] = dque.pollFirst();
            }

            dque.clear();

            //시계방향
            sr = cleaner[1][0];
            sc = cleaner[1][1]+1;
            dque.add(map[sr][sc]);
            map[sr][sc] = 0;
            while(true)
            {
                if(sr == cleaner[1][0] && sc != C-1)
                    sc++;
                else if(sc == C-1 && sr != R-1)
                    sr++;
                else if(sr == R-1 && sc != 0)
                    sc--;
                else if(sr != cleaner[1][0]+1 && sc == 0)
                    sr--;
                else
                    break;

                dque.addLast(map[sr][sc]);
                map[sr][sc] = dque.pollFirst();
            }
            dque.clear();

        }


        int answer = 0;

        for(int i = 0; i < R; ++i)
        {
            for (int j = 0; j < C; ++j)
            {
                if(map[i][j] > 0)
                    answer += map[i][j];
            }
        }
        System.out.println(answer);
    }
}
