package IronStick10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {

        FastReader fr = new FastReader();

        String command = fr.nextLine();
        ArrayList<String> arrList = new ArrayList<>();

        int ironCnt = 0;
        int ironCutedCnt = 0;


        for(int i = 0; i < command.length(); ++i)
        {
            if(command.charAt(i) == '(')
            {
                if((i+1 < command.length()) && (command.charAt(i+1) == '('))
                {
                    ironCutedCnt++;
                    ironCnt++;
                }

            }
            else if(command.charAt(i) == ')')
            {
                if(command.charAt(i-1) == '(')
                {
                    ironCutedCnt += ironCnt;
                }
                else if(command.charAt(i-1) == ')')
                {
                    ironCnt--;
                }
            }
        }

        System.out.println(ironCutedCnt);

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
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
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
