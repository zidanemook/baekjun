package 흩날리는시험지속에서내평점이느껴진거야17951;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int sum = 0;//모든 시험지 총합
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        int left = 0;
        int right = sum;
        int mid = 0;

        while(left <= right){

            int gcount = 0;//그룹 개수
            int gsum = 0;//그룹별 총합
            mid = (left+right)/2;
            for (int i = 0; i < n; i++) {

                gsum += arr[i];
                if(gsum >= mid){
                    gcount++;
                    gsum = 0;
                }
            }

            if(gcount >= k){
                left = mid+1;
            }else if(gcount < k){
                right = mid-1;
            }
        }

        System.out.println(right);
    }
}
