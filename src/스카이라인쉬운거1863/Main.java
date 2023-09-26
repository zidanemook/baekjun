package 스카이라인쉬운거1863;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);

        StringTokenizer st =null;

        int[][] points = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        int prevX = 0, prevY = 0;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            int x = points[i][0];
            int y = points[i][1];

            if (y > prevY) {
                cnt++;
            } else {
                while (!pq.isEmpty() && pq.peek() > y) {
                    pq.poll();
                }

                if (pq.isEmpty() || pq.peek() < y) {
                    cnt++;
                }
            }

            pq.add(y);
            prevY = y;

        }

        System.out.println(cnt);
    }
}
