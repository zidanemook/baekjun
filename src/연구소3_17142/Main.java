package 연구소3_17142;

import java.util.*;
import java.io.*;

public class Main {

    static int N = 0;
    static int M = 0;

    static int[][] map = null;
    static ArrayList<int[]> viruslist = new ArrayList<>();
    static int[] vset = null;
    static boolean[] visit = null;

    static final int MAX = 100000000;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        viruslist = new ArrayList<>();
        for(int i = 0; i < N; ++i)
        {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j = 0; j < N; ++j)
            {
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;

                if(temp == 2)
                    viruslist.add(new int[]{i, j});
            }
        }

        vset = new int[M];
        visit = new boolean[viruslist.size()];

        int answer = dfs(0, 0);
        if(answer == MAX)
            System.out.println(-1);
        else
            System.out.println(String.valueOf(answer));
    }

    public static int dfs(int depth, int pre) {
        if (depth == M) {
            return bfs();
        }

        int ret = MAX;
        for (int i = pre; i < viruslist.size(); ++i) {
            if (visit[i])
                continue;

            visit[i] = true;
            vset[depth] = i;
            ret = Math.min(ret, dfs(depth + 1, i));
            visit[i] = false;
        }

        return ret;
    }

    public static int bfs()
    {
        Queue<int[]> que = new LinkedList<>();
        boolean[][] visit = new boolean[N][N];

        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        int[][] copymap = new int[N][N];
        for(int i = 0; i < map.length; ++i)
        {
            copymap[i] = Arrays.copyOf(map[i], map[i].length);
        }

        for (int i = 0; i < M; i++) {
            int[] temp = viruslist.get(vset[i]);
            que.add(temp);
            visit[temp[0]][temp[1]] = true;
            copymap[temp[0]][temp[1]] = 0;
        }

        int ret = 0;
        while(que.isEmpty() == false)
        {
            int[] cur = que.poll();

            for(int i = 0; i < 4; ++i)
            {
                int nr = cur[0] + dir[i][0];
                int nc = cur[1] + dir[i][1];

                if(nr < 0 || nr >= N || nc < 0 || nc >= N)
                    continue;

                if(visit[nr][nc])
                    continue;

                if(map[nr][nc]==1)
                    continue;

                visit[nr][nc] = true;
                que.add(new int[]{nr, nc});
                copymap[nr][nc] = copymap[cur[0]][cur[1]]+1;

                if(map[nr][nc]!=2)
                ret = Math.max(ret, copymap[nr][nc]);
            }
        }

        boolean checkall = true;
        for(int i = 0; i < N; ++i)
        {
            for (int j = 0; j < N; j++) {

                if(map[i][j] == 0  && copymap[i][j] == 0)
                {
                    checkall = false;
                    break;
                }
            }
            if(false == checkall)
                break;
        }

        if(false == checkall)
            return MAX;
        else
            return ret;
    }
}
