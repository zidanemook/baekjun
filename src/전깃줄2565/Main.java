package 전깃줄2565;

import java.io.*;
import java.util.*;

class Line implements Comparable<Line>{
    int a;
    int b;

    Line(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Line o){
        return this.a < o.a ? -1 : 1;
    }
}
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] input;

        Line[] lines = new Line[n];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            lines[i] = new Line(a, b);
        }

        Arrays.sort(lines);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (lines[j].b < lines[i].b) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(n-max);
    }
}
