package 사다리3061;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            int N = Integer.parseInt(br.readLine());

            String[] input = br.readLine().split(" ");
            int[] start = new int[N+1];
            for (int j = 0; j < N; j++) {
                start[j+1] = Integer.parseInt(input[j]);
            }

            int answer = 0;
            for (int j = 1; j <= N; j++) {

                int dest = j;
                for ( ; dest <= N; dest++) {
                    if(j == start[dest])
                    {
                        break;
                    }
                }

                int st = start[dest];

                int diff = dest-st;

                while(diff > 0){

                    int temp = start[dest];
                    start[dest] = start[dest-1];
                    start[dest-1] = temp;
                    dest--;
                    diff--;
                    answer++;
                }
            }

            System.out.println(answer);
        }
    }
}
