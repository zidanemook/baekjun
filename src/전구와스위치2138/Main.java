package 전구와스위치2138;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());//2~100000

        String[] input = br.readLine().split("");
        int[] cur = new int[n];
        for (int i = 0; i < n; i++) {
            cur[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split("");
        int[] target = new int[n];
        for (int i = 0; i < n; i++) {
            target[i] = Integer.parseInt(input[i]);
        }

        int answer = pushSwitch(cur.clone(), target, 1);

        cur[0] = 1 - cur[0];
        cur[1] = 1 - cur[1];

        int temp = pushSwitch(cur, target, 1);
        if (temp != Integer.MAX_VALUE) {
            temp += 1;
        }
        answer = Math.min(answer, temp);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static int pushSwitch(int[] init, int[] goal, int idx){
        int count = 0;
        for(int i=idx; i<init.length; i++){
            if(init[i-1] != goal[i-1]){
                init[i-1] = 1 - init[i-1];
                init[i] = 1 - init[i];
                if(i != init.length - 1)
                    init[i+1] = 1 - init[i+1];
                count++;
            }
        }
        if(Arrays.equals(init, goal))
            return count;
        else
            return Integer.MAX_VALUE;
    }
}
