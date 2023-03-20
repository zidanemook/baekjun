package 회의실배정1931;

import java.io.*;
import java.util.*;

class Meeting implements Comparable<Meeting>
{
    int st;
    int ed;

    public Meeting(int st, int ed) {
        this.st = st;
        this.ed = ed;
    }

    @Override
    public int compareTo(Meeting o)
    {
        if(this.st != o.st)
            return this.st - o.st < 0 ? -1:1;
        else {
            return this.ed - o.ed < 0 ? -1:1;
        }
    }
}

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());//1~100000
        String[] input;

        PriorityQueue<Meeting> pq = new PriorityQueue<>();

        for(int i = 0; i < N; ++i)
        {
            input = br.readLine().split(" ");

            int st = Integer.parseInt(input[0]);// 0 ~ 2^31-1
            int ed = Integer.parseInt(input[1]);

            pq.add(new Meeting(st, ed));
        }

        int end = 0;
        int ans = 0;
        while(pq.isEmpty() == false)
        {
            Meeting cur = pq.poll();
            if(cur.st >= end)
            {
                ans++;
                end = cur.ed;
            }
        }
        System.out.println(ans);
    }
}