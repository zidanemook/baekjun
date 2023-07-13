package 배열돌리기1_16926;

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int r = Integer.parseInt(input[2]);

        int[][] mat = new int[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                mat[i][j] = Integer.parseInt(input[j]);
            }
        }

        //작은것을 2로 나누면 필요한 선 개수를 구한다
        int piece = Math.min(n, m)/2;

        ArrayList<ArrayList<Integer>> lines = new ArrayList<>();
        for (int i = 0; i < piece; i++) {
            lines.add(new ArrayList<>());
        }

        int row = 0;
        int col = 0;
        for (int i = 0; i < piece; i++) {

            for (int j = i; j < m-i; j++) {
                col = j;
                lines.get(i).add(mat[row][col]);
            }

            for (int j = i+1; j < n-i; j++) {
                row = j;
                lines.get(i).add(mat[row][col]);
            }

            for (int j = m-2-i; j >= i; j--) {
                col = j;
                lines.get(i).add(mat[row][col]);
            }

            for (int j = n-2-i; j > i; j--) {
                row = j;
                lines.get(i).add(mat[row][col]);
            }

            row = i+1;
            col = i+1;
        }


        row = 0;
        col = 0;
        int[][] mats = new int[n][m];
        for (int i = 0; i < piece; i++) {

            ArrayList<Integer> cur = lines.get(i);
            int start = r % cur.size();

            for (int j = i; j < m-i; j++) {
                col = j;
                mats[row][col] = cur.get(start++);

                if(start >= cur.size())
                    start = 0;
            }


            for (int j = i+1; j < n-i; j++) {
                row = j;
                mats[row][col] = cur.get(start++);

                if(start >= cur.size())
                    start = 0;
            }

            for (int j = m-2-i; j >= i; j--) {
                col = j;
                mats[row][col] = cur.get(start++);

                if(start >= cur.size())
                    start = 0;
            }

            for (int j = n-2-i; j > i; j--) {
                row = j;
                mats[row][col] = cur.get(start++);

                if(start >= cur.size())
                    start = 0;
            }

            row = i+1;
            col = i+1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cur = mats[i][j];
                if(j == m-1){
                    sb.append(cur + "\n");
                }else
                    sb.append(cur + " ");
            }
        }

        System.out.println(sb.toString());
    }
}
