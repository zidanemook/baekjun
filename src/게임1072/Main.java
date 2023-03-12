package 게임1072;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);

        int curPer = cal(x, y);

        int left = 0;
        int right = 1000000000;

        int cand = 0;
        int ans = -1;
        while(left <= right)
        {
            cand = (left + right)/2;

            if(curPer < cal(x+cand, y+cand))
            {
                ans = cand;
                right = cand-1;
            }
            else
            {
                left = cand+1;
            }
        }

        System.out.println(ans);
    }

    public static int cal(long x, long y)
    {
        long xcopy = x;
        long ycopy = y*100;
        int ret = (int)(ycopy/xcopy);
        return ret;
    }
}
