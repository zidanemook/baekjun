package PrinterQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {

        FastReader fr = new FastReader();

        int cnt = fr.nextInt();

        String[] str;
        ArrayList<Integer> arrList = new ArrayList<>();
        ArrayList<Integer> arrListSorted = new ArrayList<>();
        int cardCnt = 0;
        int cardIdx = 0;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < cnt; ++i)
        {
            arrList.clear();
            arrListSorted.clear();
            str = fr.nextLine().split(" ");

            cardCnt = Integer.parseInt(str[0]);
            cardIdx = Integer.parseInt(str[1]);

            str = fr.nextLine().split(" ");
            for(int j = 0; j < cardCnt; ++j)
            {
                arrList.add(Integer.parseInt(str[j]));
                arrListSorted.add(Integer.parseInt((str[j])));
            }

            arrListSorted.sort((Integer e1, Integer e2) -> {
                return e2 - e1;
            });

            int sortidx = 0;
            int curidx = 0;
            int ret = 0;
            while(sortidx < cardCnt)
            {
                if(arrListSorted.get(sortidx) == arrList.get(curidx))
                {
                    if(cardIdx == curidx)
                    {
                        ret++;
                        break;
                    }

                    sortidx++;
                    curidx++;
                    ret++;


                }
                else
                    curidx++;

                if(curidx >= cardCnt)
                    curidx = 0;

            }
            sb.append(ret+"\n");
        }


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
