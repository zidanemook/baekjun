package Josephus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {

        FastReader fr = new FastReader();

        String[] Line = fr.nextLine().split(" ");

        int N = Integer.parseInt(Line[0]);
        int K = Integer.parseInt(Line[1]);

        ArrayList<Integer> arrList = new ArrayList<>();
        for(int i = 1; i <= N; ++i)
        {
            arrList.add(i);
        }

        ArrayList<Integer> ret = new ArrayList();
        int idx = K-1;
        while(arrList.isEmpty() == false)
        {
            if(idx >= arrList.size())
            {
                idx -= arrList.size();
            }
            else
            {
                ret.add(arrList.remove(idx));
                idx += K-1;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int i = 0; i < ret.size(); ++i)
        {
            if(i == ret.size()-1)
                sb.append(ret.get(i));
            else
                sb.append(ret.get(i) + ", ");
        }
        sb.append(">");

        System.out.println(sb.toString());
    }

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {

            while(st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
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
            catch (IOException e)
            {
                e.printStackTrace();
            }

            return str;
        }
    }
}
