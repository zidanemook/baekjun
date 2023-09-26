package 부분직사각형1286;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] alpa = new long[26];

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            int t = (i+1) * (2* N -i) + (i+N+1) * (N-i);
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                int r = (j+1) * (2*M-j)+ (j+M+1) * (M-j);
                int idx =  input.charAt(j)  - 'A';
                alpa[idx] += t * r;
            }
        }

        for (int i = 0; i < 26; i++) {
            System.out.println(alpa[i]);
        }
    }
}
