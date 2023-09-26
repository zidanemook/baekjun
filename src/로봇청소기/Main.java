package 로봇청소기;

import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int rr = Integer.parseInt(st.nextToken());
        int rc = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for(int i = 0; i < N; ++i)
        {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        Queue<int[]> que = new LinkedList<>();

        que.add(new int[]{rr, rc});

        int[][] dir = {{-1, 0},{0, 1},{1, 0},{0,-1}};

        int answer = 0;

        while(que.isEmpty()==false)
        {
            int[] cur = que.poll();
            //현재칸 청소
            if(map[cur[0]][cur[1]] == 0)
            {
                map[cur[0]][cur[1]] = 2;
                answer++;
            }


            boolean cango = false;


            for(int i = 0; i < 4; ++i)
            {
                int nr = cur[0] + dir[i][0];
                int nc = cur[1] + dir[i][1];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M)
                    continue;

                if(map[nr][nc] != 0)
                    continue;

                cango = true;
            }

            if(cango == false)
            {
                int nr = cur[0] + -1 * dir[d][0];//바라보는 방향에서 후진
                int nc = cur[1] + -1 * dir[d][1];

                //후진 방향 못간다면 정지
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 1)
                    break;

                que.add(new int[]{nr, nc});
            }
            else {
                int nr = 0;
                int nc = 0;
                for(int i = 0; i < 4; ++i)
                {
                    d -= 1;//반시계 회전
                    if(d < 0)
                        d = 3;

                    //바라보는 방향 앞쪽 칸
                    nr = cur[0] + dir[d][0];
                    nc = cur[1] + dir[d][1];

                    if(nr < 0 || nr >= N || nc < 0 || nc >= M)
                        continue;
                    //빈칸인가
                    if(map[nr][nc] == 0)
                        break;
                }

                //전진
                que.add(new int[]{nr, nc});
            }
        }

        System.out.println(answer);
    }
}
