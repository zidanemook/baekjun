package 파일합치기3_13975;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        String[] input;
        for (int i = 0; i < T; i++)
        {

            int K = Integer.parseInt(br.readLine());//3~1000000
            input = br.readLine().split(" ");

            PriorityQueue<Long> pq = new PriorityQueue<>();

            for (int j = 0; j < K; j++)
            {
                pq.add(Long.parseLong(input[j]));//0~10000
            }

            long cost = 0;
            ArrayList<Long> list = new ArrayList<>();
            while(pq.size() != 1)
            {
                long temp1 = pq.poll();

                long temp2 = pq.poll();

                cost = temp1 + temp2;
                list.add(cost);
                pq.add(cost);

            }

            long ans = 0;
            for(long element : list)
                ans += element;

            System.out.println(ans);
        }
    }
}
