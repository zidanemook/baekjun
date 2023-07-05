package 블랙프라이데이18114;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);//1~5000
        int C = Integer.parseInt(input[1]);//10^8

        input = br.readLine().split(" ");

        int[] weight = new int[N];//1~10^8
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(weight);

        if(bin(weight, N, C) == true){
            System.out.println(1);
            return;
        }

        int left = 0;
        int right = N-1;
        while(left < right){
            int sum = weight[left] + weight[right];

            if(sum > C){
                right--;
            }
            else if(sum == C){
                System.out.println(1);
                return;
            }
            else{
                int diff = C-sum;
                if(diff != weight[left] && diff != weight[right] && bin(weight, N, diff)){
                    System.out.println(1);
                    return;
                }
                left++;
            }
        }

        System.out.println(0);
    }

    public static boolean bin(int[] weight, int N, int C){

        int left = 0;
        int right = N-1;
        int mid = (left+right)/2;

        while(left <= right){

            if(weight[mid] == C)
                return true;

            if(weight[mid] > C){
                right--;
            }else{
                left++;
            }

            mid = (left+right)/2;
        }

        return false;
    }
}
