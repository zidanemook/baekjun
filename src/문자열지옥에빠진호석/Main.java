package 문자열지옥에빠진호석;

import java.io.*;
import java.util.*;

public class Main {

    static int N;//3 ~ 10
    static int M;//3 ~ 10
    static int K;//1~1000
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        Character[][] arr = new Character[N][M];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split("");
            arr[i] = new Character[M];
            for (int j = 0; j < M; j++) {
                arr[i][j] = input[j].charAt(0);
            }
        }

        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                map.put(arr[i][j].toString(), map.getOrDefault(arr[i][j], 0)+1);
                dfs(i, j, 1, map, arr[i][j].toString(), arr);

            }
        }


        for (int i = 0; i < K; i++) {
            String s = br.readLine();
            if(map.containsKey(s)){
                System.out.println(map.get(s));
            }
            else
                System.out.println(0);
        }

    }

    public static void dfs(int row, int col, int depth, HashMap<String, Integer> map, String cur, Character[][] arr){

        if(5 <= depth){
            return;
        }
        int[][] dir = {{-1, 0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}};

        for (int k = 0; k < 8; k++) {

            //8방향
            int nrow = row + dir[k][0];
            int ncol = col + dir[k][1];

            if(nrow < 0)
                nrow = N-1;
            if(nrow >= N)
                nrow = 0;
            if(ncol < 0)
                ncol = M-1;
            if(ncol >= M)
                ncol = 0;

            String newCur = cur + arr[nrow][ncol];
            map.put(newCur, map.getOrDefault(newCur, 0)+1);
            dfs(nrow, ncol, depth+1, map, newCur, arr);
        }

    }
}
