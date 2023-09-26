package 폴짝폴짝1326;

import java.io.*;
import java.util.*;

public class Main {

    static int N = 0;
    static int[] bridge = null;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        bridge = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {

            bridge[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(bfs(a-1, b-1));

    }

    public static int bfs(int start, int end)
    {
        Queue<int[]> que = new LinkedList<>();
        boolean[] visit = new boolean[N];

        que.add(new int[]{start, 0});
        visit[start] = true;

        while(que.isEmpty()==false){

            int[] cur = que.poll();
            int stoneValue = bridge[cur[0]];

            for (int i = stoneValue; i < N; i += stoneValue) {
                int forward = cur[0] + i;
                int backward = cur[0] - i;

                if (forward < N && !visit[forward]) {
                    if (forward == end) return cur[1] + 1;
                    que.add(new int[]{forward, cur[1] + 1});
                    visit[forward] = true;
                }

                if (backward >= 0 && !visit[backward]) {
                    if (backward == end) return cur[1] + 1;
                    que.add(new int[]{backward, cur[1] + 1});
                    visit[backward] = true;
                }

                if(forward == end || backward == end)
                    return cur[1]+1;
            }

        }
        return -1;
    }
}
