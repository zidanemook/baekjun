package 한줄로서기;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] height = new int[N];
        int[] line = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; ++i)
            height[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            int emptySpaces = height[i - 1];
            for (int j = 0; j < N; j++) {
                if (emptySpaces == 0 && line[j] == 0) {
                    line[j] = i;
                    break;
                }
                if (line[j] == 0) {
                    emptySpaces--;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.print(line[i] + " ");
        }
    }
}
