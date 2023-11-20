package 숨바꼭질1697;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visit = new boolean[100001];
        Queue<int[]> que = new LinkedList<>();

        que.add(new int[]{N, 0});
        visit[N] = true;

        int answer = 0;
        while(que.isEmpty()==false){

            int[] cur = que.poll();

            if(cur[0] == K){
                answer = cur[1];
                break;
            }

            int np = cur[0]-1;
            if(np >= 0 && np <= 100000 && visit[np]==false){
                visit[np] = true;
                que.add(new int[]{np, cur[1]+1});
            }

            np = cur[0]+1;
            if(np >= 0 && np <= 100000 && visit[np]==false){
                visit[np] = true;
                que.add(new int[]{np, cur[1]+1});
            }

            np = cur[0]*2;
            if(np >= 0 && np <= 100000 && visit[np]==false){
                visit[np] = true;
                que.add(new int[]{np, cur[1]+1});
            }
        }

        System.out.println(answer);
    }
}
