package 별찍기10_2447;

import java.io.*;
import java.util.*;
public class Main {

    static char[][] arr;
    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new char[N][N];

        dfs(N, 0, 0);
    }

    public static void dfs(int depth, int x, int y){

        if(depth == 1){

            arr[x][y] = '*';

            return;
        }


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i == 1 && j == 1)
                    continue;
                dfs(depth/3, i, j);
            }
        }

    }
}
