package 기타레슨2343;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] arr = new int[n];

        input = br.readLine().split(" ");
        int left = 0;
        for(int i = 0; i < n; ++i)
        {
            arr[i] = Integer.parseInt(input[i]);
            left = Math.max(left, arr[i]);//최소한의 값은 가장 긴 강의를 블루레이에 담을 수 있을 만큼 커야한다.
        }

        int right = 10000 * n;//강의최대 길이 * 강의개수
        int cand = 0; //시간
        int ans = 0;
        //평가는 블루레이개수

        while(left <= right)
        {
            cand = (left+right)/2;
            if(cal(arr, cand) > m)
            {
                left = cand+1;
            }
            else
            {
                ans = cand;
                right = cand-1;
            }
        }

        System.out.println(ans);
    }
    public static int cal(int[] arr, int cand)
    {
        int ret = 1;
        int sum = 0;
        for(int i = 0; i < arr.length; ++i)
        {
            sum += arr[i];
            if(sum > cand)
            {
                sum= arr[i];
                ret++;
            }
        }

        return ret;
    }
}
