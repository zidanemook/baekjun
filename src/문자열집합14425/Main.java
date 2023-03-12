package 문자열집합14425;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        FastReader fr = new FastReader();

        String[] MN = fr.nextLine().split(" ");
        int M = Integer.parseInt(MN[0]);
        int N = Integer.parseInt(MN[1]);

        HashSet<String> mlist = new HashSet<>();
        for(int i = 0; i < M; ++i)
        {
            mlist.add(fr.nextLine());
        }

        int result = 0;
        for(int i = 0; i < N; ++i)
        {
            if(mlist.contains(fr.nextLine()))
                result++;
        }

        System.out.println(result);
    }
}

class FastReader
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

    int nextInt()
    {
        return Integer.parseInt(next());
    }

}
