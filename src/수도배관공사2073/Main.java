package 수도배관공사2073;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int D = Integer.parseInt(input[0]);
        int P = Integer.parseInt(input[1]);

        int[] dp = new int[D+1];
        dp[0] = Integer.MAX_VALUE;

        for (int i = 0; i < P; i++) {
            input = br.readLine().split(" ");

            int l = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);

            for (int j = D; j >= l; j--) {
                dp[j] = Math.max(dp[j], Math.min(dp[j-l], c));
            }
        }

        System.out.println(dp[D]);
    }
}
