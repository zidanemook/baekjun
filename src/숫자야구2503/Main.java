package 숫자야구2503;

import java.io.*;
import java.util.*;

public class Main {

    static class Hint
    {
        int[] hintNum;
        int stCnt;
        int baCnt;
        Hint()
        {
            hintNum = new int[3];
        }
    }

    static int tryCnt;
    static Hint[] hint;

    static int[] tryNum = new int[3];
    static boolean[] checked = new boolean[9];

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        tryCnt = Integer.parseInt(br.readLine());
        hint = new Hint[tryCnt];

        String[] input;
        for(int i = 0; i < tryCnt; ++i)
        {
            input = br.readLine().split(" ");

            hint[i] = new Hint();

            for(int j = 0; j < 3; ++j)
            {
                hint[i].hintNum[j] = input[0].charAt(j) - '0';
            }

            hint[i].stCnt = Integer.parseInt(input[1]);
            hint[i].baCnt = Integer.parseInt(input[2]);
        }

        search(0);

        System.out.println(answer);
    }

    static void search(int level)
    {
        if(level == 3)
        {
            Arrays.stream(tryNum).forEach(i -> System.out.print(i));
            System.out.println();
            if(tryMethod(tryNum))
                answer++;
            return;
        }

        for(int i = 0; i < 9; ++i)
        {
            if(checked[i]==false)
            {
                checked[i] = true;
                tryNum[level] = i+1;
                search(level+1);
                checked[i] = false;
            }
        }
    }

    static boolean tryMethod(int[] tryNum)
    {
        boolean ret = true;

        int strikeCnt = 0;
        int ballCnt = 0;
        for(int i = 0; i < tryCnt; ++i)
        {
            for (int j = 0; j < 3; ++j)
            {
                for (int k = 0; k < 3; ++k)
                {
                    if (hint[i].hintNum[j] == tryNum[k])
                    {
                        if (j == k)
                            strikeCnt++;
                        else
                            ballCnt++;
                    }
                }
            }
            if (hint[i].stCnt == strikeCnt && hint[i].baCnt == ballCnt)
            {
                //No operation
            }
            else
            {
                ret = false;
                break;
            }
            strikeCnt = 0;
            ballCnt = 0;
        }
        return ret;
    }

}
