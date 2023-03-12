package N번째큰수2075;
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        FastReader fr = new FastReader();

        int N = Integer.parseInt(fr.nextLine());

        ArrayList<ArrayList<Integer>> arrList = new ArrayList<>();

        for(int i = 0; i < N;++i)
        {
            arrList.add(new ArrayList<>());
        }

        for(int i = 0; i < N; ++i)
        {
            for(int j = 0; j < N; ++j)
            {
                arrList.get(j).add(fr.nextInt());
            }
        }

        int cnt = 0;
        int[] indexes = new int[N];
        int max = 0;
        int maxIdx = -1;
        int answer = 0;
        while(cnt < N)
        {
            max = Integer.MIN_VALUE;
            maxIdx = -1;
            for(int i = 0; i < N; ++i)
            {
                ArrayList<Integer> tmp = arrList.get(i);
                if(!tmp.isEmpty() && max < tmp.get(tmp.size()-1)) {
                    max = tmp.get(tmp.size()-1);
                    maxIdx = i;
                }
            }

            answer = arrList.get(maxIdx).remove(arrList.get(maxIdx).size()-1);
            cnt++;
        }

        System.out.println(answer);
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
