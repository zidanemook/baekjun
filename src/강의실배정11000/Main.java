package 강의실배정11000;

import java.io.*;
import java.util.*;

class Lec
{
    int s;
    int e;

    public Lec(int s, int e) {
        this.s = s;
        this.e = e;
    }
}

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());//1 ~ 200000

        ArrayList<Lec> lecList = new ArrayList<>();

        String[] input;
        for(int i = 0; i < N; ++i)
        {
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);//0 ~ 10^9
            int e = Integer.parseInt(input[1]);//s ~ 10^9
            lecList.add(new Lec(s, e));
        }

        Comparator<Lec> comparator = new Comparator<Lec>() {
            @Override
            public int compare(Lec a, Lec b) {
                if(a.e != b.e)
                    return a.e < b.e ? -1 : 1;
                else
                    return a.s < b.s ? -1 : 1;
            }
        };

        Collections.sort(lecList, comparator);

        PriorityQueue<Lec> roomList = new PriorityQueue<>(new Comparator<Lec>() {
            @Override
            public int compare(Lec a, Lec b) {
                if(a.e != b.e)
                    return a.e < b.e ? -1 : 1;
                else
                    return a.s < b.s ? -1 : 1;
            }
        });
        roomList.add(new Lec(0, 0));

        for(Lec cur : lecList)
        {
            if (cur.s >= roomList.peek().e) {
                roomList.poll();
            }
            roomList.add(cur);
        }

        System.out.println(roomList.size());
    }
}
