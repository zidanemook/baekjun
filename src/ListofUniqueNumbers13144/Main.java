package ListofUniqueNumbers13144;

import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] overlapCheck = new int[100001];

        int N = Integer.parseInt(br.readLine());//1 ≤ N ≤ 100,000
        int[] arr = new int[N];

        String[] input = br.readLine().split(" ");

        for(int i = 0; i < N; ++i)
        {
            arr[i] = Integer.parseInt(input[i]);
        }

        int l = 0;
        int r = 0;
        overlapCheck[arr[l]]++;
        int overlapCnt = 0;

        long ans = 0;
        while(l <= r)
        {
            if(r+1 < N && overlapCnt == 0)
            {
                r++;
                overlapCheck[arr[r]]++;
                if(overlapCheck[arr[r]] > 1)//중복된 숫자 나오면 개수세기
                {
                    overlapCnt++;

                    ans += (r-1)-l+1;//중복된 숫자 전의 r 값을 사용해서 개수 더하기
                }

            }
            else
            {
                if(overlapCnt == 0)
                    ans += r-l+1;

                if(overlapCheck[arr[l]] > 1)
                {
                    overlapCheck[arr[l]]--;
                    overlapCnt--;
                }

                l++;
            }
        }

        System.out.println(ans);
    }
}
