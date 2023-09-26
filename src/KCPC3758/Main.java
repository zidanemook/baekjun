package KCPC3758;

import java.util.*;
import java.io.*;

class Team implements Comparable<Team>{
    int tid;
    int score;//총점
    int cnt;//제출횟수
    int time;//마지막제출시간

    Team(int tid, int score, int cnt, int time)
    {
        this.tid = tid;
        this.score = score;
        this.cnt = cnt;
        this.time = time;
    }

    @Override
    public int compareTo(Team o)
    {
        if(score != o.score)
            return score > o.score ? -1 : 1;
        else if(cnt != o.cnt)
            return cnt < o.cnt ? -1 : 1;
        else
            return time < o.time ? -1 : 1;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());//팀개수
            int k = Integer.parseInt(st.nextToken());//문제개수
            int mytid = Integer.parseInt(st.nextToken());//팀아이디
            int m = Integer.parseInt(st.nextToken());//로그 엔트리

            //점수
            //제출횟수
            //제출시간
            PriorityQueue<Team> pq = new PriorityQueue<>();
            int[][][] arrteam = new int[n+1][k+1][3];//팀아이디, 문제아이디, 0문제별 점수, 1제출시간, 2제출횟수
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int id = Integer.parseInt(st.nextToken());//팀아이디
                int pn = Integer.parseInt(st.nextToken());//문제번호
                int sc = Integer.parseInt(st.nextToken());//점수

                if(arrteam[id][pn][0] < sc)
                {
                    arrteam[id][pn][0] = sc;
                }

                arrteam[id][pn][1] = j;
                arrteam[id][pn][2] += 1;
            }

            //총점구하기, 마지막제출시간
            for (int j = 1; j < n + 1; j++) {

                int totalscore = 0;
                int totalsubmitcnt = 0;
                int lastsubmit = 0;
                for(int l = 1; l < k+1; ++l)
                {
                    totalscore += arrteam[j][l][0];
                    lastsubmit = Math.max(lastsubmit, arrteam[j][l][1]);
                    totalsubmitcnt += arrteam[j][l][2];
                }

                pq.add(new Team(j, totalscore, totalsubmitcnt, lastsubmit));
            }

            int answer = 1;
            while(pq.isEmpty()==false)
            {
                Team team = pq.poll();
                if(mytid == team.tid)
                    break;

                answer++;
            }

            System.out.println(answer);
        }
    }
}
