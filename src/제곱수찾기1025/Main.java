package 제곱수찾기1025;

import java.io.*;

public class Main {

    static int n, m;
    static int[][] inputarr;
    static int[] arr;

    static boolean[][] visit;

    static long answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        inputarr = new int[n][m];

        for (int i = 0; i < n; i++) {
            s = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                inputarr[i][j] = Integer.parseInt(s[j]);
            }
        }

        arr = new int[Math.max(n, m)];
        visit = new boolean[n][m];

        for (int i = -n+1; i < n; i++) {
            for (int j = -m+1; j < m; j++) {
                search(0, 0, i, 0, j);
            }
        }

        System.out.println(answer);
    }

    public static void search(int depth, int row, int rdiff, int col, int cdiff){

        long num = 0;
        for (int i = 0; i < depth; i++) {
            num = num*10 + arr[i];
        }

        if(depth != 0 && isWJ(num))
            answer = Math.max(answer, num);

        if(depth == arr.length){
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if(depth != 0 && ((i-row) != rdiff || (j-col) != cdiff))
                    continue;

                if(visit[i][j] == false){

                    visit[i][j] = true;
                    arr[depth] = inputarr[i][j];
                    search(depth+1, i, rdiff, j, cdiff);
                    visit[i][j] = false;
                }
            }
        }

    }

    public static boolean isWJ(long num){

        double sqrt = Math.sqrt(num);

        if(Math.ceil(sqrt) == sqrt)
            return true;

        return false;
    }
}
