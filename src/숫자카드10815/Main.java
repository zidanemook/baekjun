package 숫자카드10815;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] card = new int[n];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n; ++i)
        {
            card[i] = Integer.parseInt(input[i]);
        }

        int m = Integer.parseInt(br.readLine());
        int[] nums = new int[m];
        input = br.readLine().split(" ");
        for(int i = 0; i < m; ++i)
        {
            nums[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(card);

        int left = 0;
        int right = card.length-1;
        int cand = 0;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; ++i)
        {
            left = 0;
            right = card.length-1;

            boolean find = false;
            while (left <= right)
            {
                cand = (left+right)/2;
                if(nums[i] == card[cand])
                {
                    find = true;
                    break;
                }
                else if(nums[i] < card[cand])
                {
                    right = cand-1;
                }
                else
                {
                    left = cand+1;
                }
            }

            if(find)
                sb.append("1" + " ");
            else
                sb.append("0" + " ");
        }

        System.out.println(sb);
    }
}
