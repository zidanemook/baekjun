package Balloon2346;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args)
    {
        FastReader fr = new FastReader();

        int ballooncnt = fr.nextInt();

        ArrayList<Integer> arrList = new ArrayList<>();

        for(int i = 0; i < ballooncnt; ++i)
        {
            arrList.add(fr.nextInt());
        }

        int none = 9999;
        int idx = 0;
        int pang = 0;
        int pangcopy = 0;

        StringBuilder sb = new StringBuilder();

        int NoneCnt = 0;
        while(NoneCnt < ballooncnt)
        {

            if(arrList.get(idx) == none)
            {
                if(pangcopy > 0)
                {
                    idx++;
                }
                else if(pangcopy < 0)
                {
                    idx--;
                }

            }
            else
            {
                if(pang == 0)
                {
                    pang = arrList.get(idx);
                    pangcopy = pang;
                    arrList.set(idx, none);
                    NoneCnt++;
                    if(NoneCnt == ballooncnt)
                    {
                        sb.append(idx+1);
                    }
                    else
                    {
                        sb.append((idx+1)+" ");
                    }
                }

                if(pangcopy > 0)
                {
                    idx++;
                    pang--;
                }
                else if(pangcopy < 0)
                {
                    idx--;
                    pang++;
                }

            }

            if(idx >= ballooncnt)
                idx = 0;

            if(idx < 0)
                idx = ballooncnt-1;
        }

        System.out.println(sb.toString());
    }

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        FastReader()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next()
        {
            while(st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String readLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

    }
}
