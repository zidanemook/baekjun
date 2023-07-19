package 주유소13305;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] roadlen = new long[n-1];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n-1; i++) {
            roadlen[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        long[] price = new long[n];
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(input[i]);
        }

        long answer = 0;
        for (int i = 0; i < n-1; i++) {
            if(price[i] < price[i+1]){
                //낮은거 나올때까지
                int next = i+1;
                while(true){

                    answer += price[i]*roadlen[next-1];
                    next++;

                    if(next >= n){
                        i = next;
                        break;
                    }

                    if(price[i] > price[next]){
                        answer += price[i]*roadlen[next-1];
                        i = next-1;
                        break;
                    }

                }

            }else{
                answer += (price[i] * roadlen[i]);
            }
        }

        System.out.println(answer);
    }
}
