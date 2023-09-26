package 원판돌리기17822;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());//원판개수
        int M = Integer.parseInt(st.nextToken());//숫자개수
        int T = Integer.parseInt(st.nextToken());//회전수

        int[][] map = new int[N+1][M+1];


        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < M+1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < T; i++) {

            st = new StringTokenizer(br.readLine(), " ");

            //회전하기
            int X = Integer.parseInt(st.nextToken());//배수
            int D = Integer.parseInt(st.nextToken());//방향
            int K = Integer.parseInt(st.nextToken());//이동

            int[] idx = new int[N+1];
            Arrays.fill(idx, 1);

            for (int j = 1; j < N+1; j++) {

                if(j%X!=0)
                 continue;

                if(D == 0)//시계방향
                {
                    idx[j] -= K%M;
                    if(idx[j] < 1)
                        idx[j] += M;
                }
                else {
                    idx[j] += K%M;
                    if(idx[j] >= M+1)
                        idx[j] -= M;
                }
            }

            int[][] copymap = new int[N+1][M+1];
            //회전결과 저장
            for (int j = 1; j < N+1; j++) {

                int k = idx[j];
                int cnt = 1;
                while(cnt < M+1)
                {
                    copymap[j][cnt] = map[j][k];
                    k++;
                    if(k>=M+1)
                        k = 1;
                    cnt++;
                }
            }

            //인접한 같은숫자 제거
            boolean[][] visit = new boolean[N+1][M+1];
            int exist = 0;
            for (int j = 1; j < N+1; j++) {
                for (int k = 1; k < M+1; k++) {

                    if(visit[j][k])
                        continue;

                    if(copymap[j][k] == 0)
                        continue;

                    exist += bfs(new int[]{j, k}, copymap, visit, N, M);

                }
            }

            if(exist == 0)//인접한 같은 숫자 없었음
            {
                //평균구하기
                int total = 0;
                int cnt = 0;
                float avg = 0.f;
                for (int j = 1; j < N+1; j++) {
                    for (int k = 1; k < M + 1; k++) {
                        if(copymap[j][k] > 0)
                        {
                            total += copymap[j][k];
                            cnt++;
                        }

                    }
                }

                avg = (float)total / (float)cnt;

                for (int j = 1; j < N+1; j++) {
                    for (int k = 1; k < M + 1; k++) {

                        if(copymap[j][k] > 0){
                            float temp = copymap[j][k];

                            if(temp < avg)
                                copymap[j][k]++;
                            else if(temp > avg)
                                copymap[j][k]--;
                        }

                    }
                }
            }

            for (int j = 1; j < N+1; j++) {
                for (int k = 1; k < M+1; k++) {
                    map[j][k] = copymap[j][k];
                }
            }

        }

        int answer = 0;

        for (int j = 1; j < N+1; j++) {
            for (int k = 1; k < M + 1; k++) {
                if(map[j][k] > 0){
                    answer += map[j][k];
                }
            }
        }

        System.out.println(answer);
    }

    public static int bfs(int[] start, int[][] copymap, boolean[][] visit, int N, int M)
    {
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        List<int[]> delete = new LinkedList<>();

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{start[0], start[1]});
        delete.add(new int[]{start[0], start[1]});
        visit[start[0]][start[1]] = true;



        while(que.isEmpty()==false) {

            int[] cur = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dir[i][0];
                int ny = cur[1] + dir[i][1];

                if(nx <= 0 || nx >= N+1)
                    continue;

                if(ny <= 0)
                    ny = M;
                if(ny >= M+1)
                    ny -= M;

                if(visit[nx][ny])
                    continue;

                if(copymap[cur[0]][cur[1]] != copymap[nx][ny])
                    continue;


                visit[nx][ny] = true;
                que.add(new int[]{nx, ny});
                delete.add(new int[]{nx, ny});
            }

        }

        if(delete.size() > 1)
        {
            for(int[] ele : delete)
            {
                copymap[ele[0]][ele[1]] = 0;
            }
            return 1;
        }
        else {
            return 0;
        }
    }
}
