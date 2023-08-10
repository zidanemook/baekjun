package 친구팰린드롬15270;

import java.io.*;
import java.util.*;
public class Main {

    static int n;
    static int m;
    static int[][] edges;
    static boolean[] visit;

    static int answer;
    public static void main(String[] sdf) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        visit = new boolean[n+1];

        if (m == 0) {
            System.out.println(1);
            return;
        }

        edges = new int[m][2];

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            edges[i][0] = a;
            edges[i][1] = b;
        }

        dfs(0, 0);

        answer *= 2;

        if(answer < n){
            answer++;
        }

        System.out.println(answer);
    }

    public static void dfs(int depth, int count){
       if(depth >= m){
           answer = Math.max(answer, count);
           return;
       }

       if(visit[edges[depth][0]] || visit[edges[depth][1]]){//둘중에 한명이 다른 짝이 있음
           dfs(depth+1, count);
       }else{
           visit[edges[depth][0]] = true;
           visit[edges[depth][1]] = true;

           dfs(depth+1, count+1);//짝을 이룬 경우 처리

           visit[edges[depth][0]] = false;
           visit[edges[depth][1]] = false;

           dfs(depth+1, count);//짝을 이루지 않을경우 처리
       }
    }
}
