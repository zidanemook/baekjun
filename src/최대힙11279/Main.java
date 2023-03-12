package 최대힙11279;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        FastReader fr = new FastReader();

        int N = Integer.parseInt(fr.nextLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

        StringBuilder sb = new StringBuilder();
        int tmp = 0;
        for(int i = 0; i < N; ++i)
        {
            tmp = Integer.parseInt(fr.nextLine());
            if(tmp == 0)
            {
                if(pq.isEmpty())
                    sb.append(0);
                else
                    sb.append(pq.poll());

                if(i != N-1)
                    sb.append("\n");
            }
            else
                pq.add(tmp);
        }

        System.out.println(sb.toString());
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