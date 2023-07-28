package 두용액2470;

import java.io.*;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        int left = 0;
        int right = N-1;

        int bestvalue = Integer.MAX_VALUE;
        int bestleft = 0;
        int bestright = 0;
        while(left < right){

            int sum = arr[left] + arr[right];

            if(Math.abs(sum) < bestvalue){
                bestvalue = Math.abs(sum);
                bestleft = left;
                bestright = right;
            }



            if( sum > 0){
                right--;
            }else if(sum < 0){
                left++;
            }else{
                bestleft = left;
                bestright = right;
                break;
            }
        }

        System.out.println(arr[bestleft] + " " + arr[bestright]);
    }
}
