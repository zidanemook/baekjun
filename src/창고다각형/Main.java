package 창고다각형;

import java.io.*;
import java.util.*;

class gidung implements Comparable<gidung>
{
    int p;
    int h;

    public gidung(int p, int h)
    {
        this.p = p;
        this.h = h;
    }

    @Override
    public int compareTo(gidung o)
    {
        return Integer.compare(this.p, o.p);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] highest = new int[2];
        ArrayList<gidung> arr = new ArrayList<>();

        for(int i = 0; i < N; ++i)
        {
            st = new StringTokenizer(br.readLine(), " ");
            int pos = Integer.parseInt(st.nextToken());
            int hi = Integer.parseInt(st.nextToken());
            arr.add(new gidung(pos, hi));

            if(highest[1] < hi)
            {
                highest[0] = pos;
                highest[1] = hi;
            }
        }

        Collections.sort(arr);

        //왼쪽에서 접근
        int curhi = 0;
        int prep = 0;
        int area = 0;

        for(gidung cur : arr)
        {
            area += curhi*(cur.p-prep);

            if(cur.p == highest[0])
                break;

            if(curhi < cur.h)
                curhi = cur.h;
            prep = cur.p;
        }
        int right = arr.size()-1;
        curhi = 0;
        for(int i = right; i >=0; --i)
        {
            gidung cur = arr.get(i);
            area += curhi*(prep-cur.p);

            if(cur.p == highest[0])
                break;

            if(curhi < cur.h)
                curhi = cur.h;
            prep = cur.p;
        }

        area += highest[1];

        System.out.println(area);
    }
}
