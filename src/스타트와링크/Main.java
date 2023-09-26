package 스타트와링크;

import java.io.*;
import java.util.*;

public class Main {

    static int answer = 1000000;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];

        for(int i = 0; i < N; ++i)
        {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0;j < N; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int tsize = N/2;

        int[] team = new int[tsize];
        boolean[] visit = new boolean[N];

        brute(0, team, visit, map, 0);

        System.out.println(answer);
    }

    public static void brute(int depth, int[] team, boolean[] visit, int[][] map, int pre)
    {
        if(depth == team.length)
        {

            //팀별로 점수 계산
            int ateam = 0;
            for(int i = 0; i < team.length; ++i)
            {
                for(int j = i+1; j < team.length; ++j)
                {
                    ateam += score(team[i], team[j], map);
                }
            }

            //HashSet<Integer> set = new HashSet<>();
            //for(int ele : team)
            //    set.add(ele);

            int bteam = 0;
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = 0; i < team.length*2; ++i)
            {
                if(visit[i]==false)
                    arr.add(i);
            }

            for(int i = 0; i < arr.size(); ++i)
            {
                for(int j = i+1; j < arr.size(); ++j)
                {
                    bteam += score(arr.get(i), arr.get(j), map);
                }
            }

            answer = Math.min(answer, Math.abs(ateam-bteam));

            return;
        }


        for(int i = pre; i < team.length*2; ++i)
        {
            if(visit[i])
                continue;

            visit[i] = true;
            team[depth] = i;
            brute(depth+1, team, visit, map, i);
            visit[i] = false;
        }
    }

    public static int score(int a, int b, int[][] map)
    {
        return map[a][b] + map[b][a];
    }
}
