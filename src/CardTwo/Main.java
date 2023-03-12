package CardTwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args)
    {
        FastReader fr = new FastReader();

        int num = fr.nextInt();

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= num; ++i)
            q.add(i);

        int tmp = 0;
        while(q.size() > 1)
        {
            q.poll();
            tmp = q.poll();
            q.add(tmp);
        }

        System.out.println(q.peek());
    }

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
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

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        String nextLine()
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
    }
}
