package AB16953;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        if(A == B)
            System.out.println(0);

        int ans = bfs(A, B);

        if(ans != -1)
            ans += 1;

        System.out.println(ans);
    }

    private static int bfs(long A, int B)
    {

        int ret = -1;

        Queue<Long> que = new LinkedList<>();
        que.add(A);

        HashMap<Long, Integer> map = new HashMap<>();
        map.put(A, 0);

        long[] next = new long[2];
        while(que.isEmpty() == false && ret == -1)
        {
            long cur = que.poll();

            next[0] = cur * 2;
            next[1] = cur*10 + 1;
            for(int i = 0; i < 2; ++i)
            {
                if(next[i] > B)
                    continue;

                if(map.containsKey(next[i]) == false)
                {
                    que.add(next[i]);
                    map.put(next[i], map.get(cur)+1);
                }

                if(next[i] == B)
                {
                    ret = map.get(next[i]);
                    break;
                }
            }

        }

        return ret;
    }
}
