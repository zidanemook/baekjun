package 갤러리2115;

import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        int[][] map = new int[M][N];

        for (int i = 0; i < M; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                if(input[j].equals("X"))
                    map[i][j] = 1;
                else
                    map[i][j] = 0;
            }
        }

        int answer = 0;

        for (int i = 1; i < M; i++) {
            int cnt = 0;
            for (int j = 1; j < N-1; j++) {
                if(map[i][j] == 0 && map[i-1][j] == 1){
                    cnt++;
                }else{
                    answer += cnt/2;
                    cnt = 0;
                }
            }
            answer += cnt/2;
        }

        for (int i = 1; i < M-1; i++) {
            int cnt = 0;
            for (int j = 1; j < N-1; j++) {
                if(map[i][j] == 0 && map[i+1][j] == 1){
                    cnt++;
                }else{
                    answer += cnt/2;
                    cnt = 0;
                }
            }
            answer += cnt/2;
        }

        for (int i = 1; i < N-1; i++) {
            int cnt = 0;
            for (int j = 1; j < M - 1; j++) {
                if(map[j][i] == 0 && map[j][i-1] == 1){
                    cnt++;
                }else{
                    answer += cnt/2;
                    cnt = 0;
                }
            }
            answer += cnt/2;
        }

        for (int i = 1; i < N-1; i++) {
            int cnt = 0;
            for (int j = 1; j < M-1; j++) {
                if(map[j][i] == 0 && map[j][i+1] == 1){
                    cnt++;
                }else{
                    answer += cnt/2;
                    cnt = 0;
                }
            }
            answer += cnt/2;
        }

        System.out.println(answer);
    }
}
