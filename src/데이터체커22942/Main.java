package 데이터체커22942;

import java.io.*;
import java.util.*;

class Round implements Comparable
{
    public int center;
    public int radius;
    public int left;
    public int right;

    public Round(int center, int radius) {
        this.center = center;
        this.radius = radius;

        left = center - radius;
        right = center + radius;
    }

    @Override
    public int compareTo(Object o) {
        return left - ((Round)o).left;
    }
}

public class Main {
    public static void main(String[] args)
    {

        FastReader fr = new FastReader();
        int roundCnt = Integer.parseInt(fr.nextLine());

        String[] roundInfo;
        ArrayList<Round> arrList = new ArrayList<>();
        for(int i = 0; i < roundCnt; ++i)
        {
            roundInfo = fr.nextLine().split(" ");

            arrList.add(new Round(Integer.parseInt(roundInfo[0]), Integer.parseInt(roundInfo[1])));
        }

        //arrList.sort((r1, r2)-> r1.left-r2.left);
        Collections.sort(arrList);

        for(int i = 0; i < arrList.size(); ++i)
        {
            if((i+1 <arrList.size()) &&
               (arrList.get(i).left <= arrList.get(i+1).left) &&
               (arrList.get(i).right >= arrList.get(i+1).left) &&
               (arrList.get(i).right <= arrList.get(i+1).right))
            {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
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
}
