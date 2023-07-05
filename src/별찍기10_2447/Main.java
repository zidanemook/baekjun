package 별찍기10_2447;

import java.io.*;
import java.util.*;
public class Main {

    static char[][] arr;
    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new char[N][N];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = ' ';
            }
        }

        dfs(N, 0, 0);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void dfs(int depth, int x, int y){

        if(depth == 1){
            arr[x][y] = '*';
            return;
        }

        int nx = x*3;
        int ny = y*3;

        for (int i = nx; i < nx+3; i++) {
            for (int j = ny; j < ny+3; j++) {
                if(i == nx+1 && j == ny+1)
                    continue;
                dfs(depth/3, i, j);
            }
        }

    }
}
