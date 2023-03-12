package 탑2493;

import java.io.*;
import java.util.*;

public class Main {

    static class Razor implements Comparable<Razor>
    {
        int startpos;
        int height;

        public Razor(int startpos, int height) {
            this.startpos = startpos;
            this.height = height;
        }


        @Override
        public int compareTo(Razor o) {
            return this.height - o.height;
        }
    }


    public static void main(String[] args) {

        FastReader fr = new FastReader();

        int towerCnt = Integer.parseInt(fr.nextLine());//탑의 수 1 이상 500,000

        //탑의 높이를 받아와~
        ArrayList<Integer> heightlist = new ArrayList<>();//N개의 탑들의 높이
        ArrayList<Integer> ret = new ArrayList<>();
        for(int i = 0; i < towerCnt; ++i)
        {
            heightlist.add(fr.nextInt());
            ret.add(-1);
        }

        int icount = 0;

        //오른쪽에서 왼쪽으로 레이저를 쏠거야 쏠때마다 높이, 시작지점 저장. 최소힙을 사용해서. 오름차순으로 정렬한다
        PriorityQueue<Razor> qRazor = new PriorityQueue<>();
        for(int i = heightlist.size()-1; i >= 0; --i)
        {
            qRazor.add(new Razor(i, heightlist.get(i)));

            while(!qRazor.isEmpty())
            {
                icount++;
                if(qRazor.peek().height < heightlist.get(i))//작은타워부터 충돌하면 충돌지점을 ret에 저장
                {
                    Razor tmp = qRazor.poll();
                    ret.set(tmp.startpos, i);
                }
                else
                    break;

            }
        }

        System.out.println("icount: "+ icount);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ret.size(); ++i)
        {
            sb.append(ret.get(i) + 1);//인덱스 값 +1 보정

            if(i != ret.size()-1)
                sb.append(" ");
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
}
