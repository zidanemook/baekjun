package 숫자카드2_10816;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());//500000
        String[] input = br.readLine().split(" ");

        HashMap<Integer, Integer> map = new HashMap<>();

        int cur = 0;
        for (int i = 0; i < N; i++) {
            cur = Integer.parseInt(input[i]);
            map.put(cur, map.getOrDefault(cur, 0)+1);
        }

        int M = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        int num = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            num = Integer.parseInt(input[i]);
            if(i == M-1)
                sb.append(map.getOrDefault(num, 0));
            else
                sb.append(map.getOrDefault(num, 0) + " ");
        }

        System.out.println(sb);
    }
}
