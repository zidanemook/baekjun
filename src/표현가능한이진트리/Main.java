package 표현가능한이진트리;

import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {

        int[] answer = new int[numbers.length];

        for(int i = 0; i < numbers.length; ++i)
        {
            long cur = numbers[i];

            StringBuilder sb = new StringBuilder();

            while(cur>=2){
                sb.append(cur%2);
                cur/=2;
            }

            if(cur==1)
                sb.append(cur);

            sb.reverse();

            String ret = sb.toString();

            int idx = 2;
            while (true) {
                if (sb.length() <= idx - 1) break;
                idx *= 2;
            }
            for (int j = 0; j < idx - 1 - sb.length(); j++)
                ret = "0" + ret;

            sb.setLength(0);
            sb.append(ret);


            //System.out.println(sb);

            int maxdepth = 0;
            int len = sb.length();
            while(len > 1){
                len/=2;
                maxdepth++;
            }

            boolean good = true;

            if(sb.length() == 1 && sb.charAt(0) == '0')
                good = false;

            for(int j = 0; j < sb.length(); ++j)
            {
                if(j % 2 == 1 && sb.charAt(j) != '1')
                {

                    int cnt = maxdepth - getlevel(0, sb.length()/2, sb.length()/2, j);

                    int left = j-1;
                    int right = j+1;

                    while(cnt > 0)
                    {
                        if (sb.charAt(left) != '0' || sb.charAt(right) != '0') {
                            good = false;
                            break;
                        }
                        left--;
                        right++;
                        cnt--;
                    }

                    if(!good) {
                        break;
                    }
                }
            }

            if(good)
                answer[i] = 1;
            else
                answer[i] = 0;

        }


        return answer;
    }
    public int getlevel(int depth, int mid, int len, int index)
    {
        if(index == mid)
            return depth;

        if(len == 1)
            return 0;

        int ret = 0;
        ret = getlevel(depth+1, mid + len/2 + 1, len/2, index);

        if(ret != 0)
            return ret;

        ret = getlevel(depth+1, mid - len/2 - 1, len/2, index);

        return ret;
    }
}
public class Main {

    public static void main(String[] args) {

        Solution sol = new Solution();

        long[] input = {15 ,23 ,42};
        int[] solution = sol.solution(input);
        for(int i : solution){
            System.out.print(i);
        }
        System.out.println();
    }


}
