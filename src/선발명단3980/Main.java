package 선발명단3980;

import java.io.*;

public class Main {

    static int[][] player;
    static int answer = 0;

    static int[] lineup;

    static boolean[] visit;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        String[] input;
        for (int i = 0; i < t; i++) {

            player = new int[11][11];

            for (int j = 0; j < 11; j++) {

                input = br.readLine().split(" ");
                for (int k = 0; k < 11; k++) {
                    player[j][k] = Integer.parseInt(input[k]);
                }
            }

            lineup = new int[11];
            visit = new boolean[11];

            brute(0);

            System.out.println(answer);
            answer = 0;
        }
    }

    public static void brute(int depth){

        if(depth == 11){

            int total = 0;
            for (int i = 0; i < 11; i++) {
                total += player[lineup[i]][i];
            }
            answer = Math.max(answer, total);

            return;
        }


        for (int i = 0; i < 11; i++) {

            if(visit[i])
                continue;

            if(player[i][depth] == 0)
                continue;

            visit[i] = true;
            lineup[depth] = i;//포지션(열), 선수(행)
            brute(depth+1);

            visit[i] = false;
        }
    }
}
