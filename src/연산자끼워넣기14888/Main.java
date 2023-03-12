package 연산자끼워넣기14888;

import java.io.*;
import java.util.*;

public class Main
{
    static BufferedReader br;

    static int[] op;//value:  add 0, sub 1, mul 2, div 3

    static int[] arr;
    static int[] nums;
    static int N;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static boolean[] checked;

    static int count = 0;//testcode

    public static void main(String[] args) throws IOException
    {
        inputProcess();

        search(0);

        System.out.println(max);
        System.out.println(min);

        System.out.println(count);//testcode
    }

    public static void inputProcess() throws IOException
    {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        arr = new int[N-1];
        op = new int[N-1];
        checked = new boolean[N-1];

        String[] input = br.readLine().split(" ");

        for(int i = 0; i < N; ++i)
        {
            nums[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");

        int[] inputOp = new int[4];
        for(int i = 0; i < 4; ++i)
        {
            inputOp[i] = Integer.parseInt(input[i]);
        }

        int opkind = 0;//value:  add 0, sub 1, mul 2, div 3
        int opcnt = 0;//0 ~ N-1
        while(opcnt < N-1)
        {
            if (inputOp[opkind] > 0)
            {
                op[opcnt] = opkind;
                inputOp[opkind]--;
                opcnt++;
            }
            else
                opkind++;

        }
    }

    public static void search(int depth)
    {
        if(depth == N-1)
        {
            count++;//testcode

            int temp = nums[0];
            for(int i = 0; i < arr.length; ++i)
            {
                if(0 == arr[i])
                    temp += nums[i+1];
                else if(1 == arr[i])
                    temp -= nums[i+1];
                else if(2 == arr[i])
                    temp *= nums[i+1];
                else
                    temp /= nums[i+1];
            }

            max = Math.max(max, temp);
            min = Math.min(min, temp);

            return;
        }

        for(int i = 0; i < N-1; ++i)
        {

            if(false == checked[i])//원소를 한번만 사용하는것
            {
                arr[depth] = op[i];
                checked[i] = true;
                search(depth+1);
                checked[i] = false;
            }

        }
    }
}
