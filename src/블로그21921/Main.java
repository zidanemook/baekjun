package 블로그21921;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] day = new int[n];
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < n; ++i)
        {
            day[i] = Integer.parseInt(st.nextToken());
        }

        long visit = 0;
        int left = 0;
        int right = x-1;
        int cnt = 0;

        long cursum = 0;
        for(int i = left; i <= right; ++i)
        {
            cursum += day[i];
        }

        while(right < day.length)
        {
            if(visit <= cursum)
            {
                if(visit == cursum)
                    cnt++;
                if(visit < cursum)
                    cnt = 1;

                visit = cursum;
            }

            cursum -= day[left];
            left++;

            right++;
            if(right < day.length)
                cursum += day[right];
        }

        if(visit == 0)
            System.out.println("SAD");
        else {
            System.out.println(visit);
            System.out.println(cnt);
        }

    }
}
