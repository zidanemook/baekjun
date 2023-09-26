package 용액2467;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] liquid = new int[N];

        String[] input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            liquid[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(liquid);

        int left = 0;
        int right = N-1;

        int minmix = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while(left < right)
        {
            int mix = liquid[left]+liquid[right];

            if(minmix > Math.abs(mix))
            {
                minmix = Math.abs(mix);
                answer[0] = left;
                answer[1] = right;
            }

            if(mix > 0) {
                right--;
            }else if(mix < 0){
                left++;
            }else{
                break;
            }
        }

        System.out.println(liquid[answer[0]] + " " + liquid[answer[1]]);
    }
}
