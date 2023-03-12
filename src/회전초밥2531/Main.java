package 회전초밥2531;

import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);//2 ≤ N ≤ 30,000
        int d = Integer.parseInt(input[1]);//2 ≤ d ≤ 3,000
        int k = Integer.parseInt(input[2]);//2 ≤ k ≤ 3,000 (k ≤ N)
        int c = Integer.parseInt(input[3]);//1 ≤ c ≤ d

        int[] arr = new int[N];
        for(int i = 0; i < N; ++i)
        {
            arr[i] = Integer.parseInt(br.readLine());
        }

        //k 개수만큼 종류 파악
        int typeCnt = 0;
        int[] type = new int[d+1];//종류별 개수
        for(int i = 0; i < k; ++i)
        {
            if(type[arr[i]] == 0)
                typeCnt++;

            type[arr[i]]++;
        }

        //쿠폰
        if(type[c] == 0)
            typeCnt++;
        type[c]++;

        int ans = typeCnt;
        int i = k;
        while(true)
        {
            if(i >= N)
                i = 0;

            int del = i-k;
            if(del < 0)
                del += N;
            type[arr[del]]--;
            if(type[arr[del]] == 0)
                typeCnt--;

            if(type[arr[i]] == 0)
                typeCnt++;
            type[arr[i]]++;

            ans = Math.max(ans, typeCnt);
            i++;

            if(i == k)
                break;
        }

        System.out.println(ans);
    }
}
