package 선물1166;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int l = Integer.parseInt(input[1]);
        int w = Integer.parseInt(input[2]);
        int h = Integer.parseInt(input[3]);

        double left = 0;
        double right = Math.max(l, Math.max(w, h));

        for (int i = 0; i < 10000; i++) {
            double mid = (left+right)/2;
            long count = (long)(l/mid) * (long)(w/mid) * (long)(h/mid);

            if(count >= n){
                left = mid;
            }else{
                right = mid;
            }
        }

        System.out.printf("%.9f\n", left);
    }
}
