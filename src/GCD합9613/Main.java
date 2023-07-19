package GCD합9613;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        String[] input;
        for (int i = 0; i < t; i++) {

            input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int[] nums = new int[n];
            for (int j = 1; j < n+1; j++) {
                nums[j-1] = Integer.parseInt(input[j]);
            }

            //최대공약수
            long answer = 0;
            for (int j = 0; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    int a = Math.min(nums[j], nums[k]);
                    int b = Math.max(nums[j], nums[k]);

                    int num = 1;
                    while(num != 0){
                        num = b%a;
                        if(num == 0){
                            break;
                        }
                        b = a;
                        a = num;
                    }
                    answer += a;
                }
            }

            System.out.println(answer);
        }
    }
}
