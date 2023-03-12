package 겹치는건싫어20922;

import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");

        int[] arr = new int[N];
        for(int i = 0; i < N; ++i)
        {
            arr[i] = Integer.parseInt(input[i]);
        }

        int l = 0;
        int r = 0;
        int cntOverlap = 0;
        int[] ncnt = new int[200001];
        ncnt[arr[l]]++;

        int ans = 0;
        while(r+1 < N)
        {
            if(l < r && cntOverlap > K)
            {
                if(ncnt[arr[l]] > K)
                    cntOverlap--;

                ncnt[arr[l]]--;

                l++;
            }
            else//cntOverlap < K
            {
                r++;
                ncnt[arr[r]]++;
                if(ncnt[arr[r]] > cntOverlap)
                    cntOverlap = ncnt[arr[r]];

                if(cntOverlap <= K)
                    ans = Math.max(ans, r-l+1);
            }
        }

        System.out.println(ans);
    }
}
