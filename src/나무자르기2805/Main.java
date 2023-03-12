package 나무자르기2805;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        Integer[] arrTree = new Integer[N];

        input = br.readLine().split(" ");
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; ++i)
        {
            arrTree[i] = Integer.parseInt(input[i]);
            max = Math.max(max, arrTree[i]);
        }

        Arrays.sort(arrTree, Collections.reverseOrder());

        long low = 0;
        long high = max;
        long cut;
        long result;
        while((high - low) > 1)//차이가 1 (포함)이하 일경우 나간다
        {
            result = 0;
            cut = (low+high) / 2;

            for(int i = 0; i < N; ++i)
            {
                if(arrTree[i] > cut)
                    result += arrTree[i] - cut;
                else
                    break;
            }
            if(result > M)
            {
                low = cut;
            }
            else if(result < M)
            {
                high = cut;
            }
            else
            {
                low = cut;
                high = cut;
            }
        }

        System.out.println(low);
    }
}
