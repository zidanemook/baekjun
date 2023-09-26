package 뱀3190;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());//보드크기
        int K = Integer.parseInt(br.readLine());//사과개수

        int[][] map = new int[N][N];

        StringTokenizer st = null;
        for(int i = 0; i < K; ++i)
        {
            st = new StringTokenizer(br.readLine(), " ");

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r-1][c-1] = 1;
        }

        int L = Integer.parseInt(br.readLine());//방향변환 개수

        Map<Integer, String> handle = new HashMap<>();
        for(int i = 0; i < L; ++i)
        {
            st = new StringTokenizer(br.readLine(), " ");
            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            handle.put(time, dir);
        }

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int curDir = 1;
        LinkedList<int[]> snake = new LinkedList<>();
        snake.add(new int[]{0, 0});

        int time = 0;

        while(true)
        {
            time++;

            int[] head = snake.getFirst().clone();
            head[0] += directions[curDir][0];
            head[1] += directions[curDir][1];

            //머리가 벽에 닿았는지
            if(head[0] < 0 || head[0] >= N || head[1] < 0 || head[1] >= N)
                break;

            //머리가 몸에 닿았는지
            boolean collide = false;
            for(int[] part : snake)
            {
                if(head[0] == part[0] && head[1] == part[1])
                {
                    collide = true;
                    break;
                }
            }
            if(collide)
                break;

            //사과 있는지
            if(map[head[0]][head[1]] == 1)
            {
                map[head[0]][head[1]] = 0;
            }
            else
            {
                snake.removeLast();
            }

            //몸 업데이트
            snake.addFirst(head);
            if(handle.containsKey(time))
            {
                if("L".equals(handle.get(time)))
                {
                    curDir = (curDir - 1 + 4) % 4;
                }
                else
                {
                    curDir = (curDir + 1) % 4;
                }
            }
        }

        System.out.println(time);
    }
}
