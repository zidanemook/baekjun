package 풍선공장15810;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] staff = new int[n];
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            staff[i] = Integer.parseInt(input[i]);
        }

        long l = 0;
        long r = 1000000000000l;//최대 시간
        long time = 0;
        long cnt = 0;

        while(l <= r){

            time = (l+r)/2;

            for (int i = 0; i < n; i++) {
                cnt += time / staff[i];
            }

            if(cnt >= m){
                r = time-1;
            }else if(cnt < m){
                l = time+1;
            }

            cnt = 0;
        }

        for (int i = 0; i < n; i++) {
            cnt += l / staff[i];
        }
        if(cnt >= m){
            System.out.println(l);
        } else {
            System.out.println(r);
        }
    }
}
