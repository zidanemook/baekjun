package 이차원배열과연산;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken());

        int[][] A = new int[100][100];
        int rowSize = 3, colSize = 3;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (time <= 100) {
            if (A[r][c] == k) {
                System.out.println(time);
                return;
            }

            if (rowSize >= colSize) {
                int maxCol = 0;
                for (int i = 0; i < rowSize; i++) {
                    int[] count = new int[101];
                    for (int j = 0; j < colSize; j++) {
                        if (A[i][j] == 0) continue;
                        count[A[i][j]]++;
                    }

                    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
                    for (int j = 1; j <= 100; j++) {
                        if (count[j] > 0) {
                            pq.add(new int[]{j, count[j]});
                        }
                    }

                    int colIdx = 0;
                    while (!pq.isEmpty()) {
                        int[] cur = pq.poll();
                        A[i][colIdx++] = cur[0];
                        A[i][colIdx++] = cur[1];
                        if (colIdx >= 100) break;
                    }
                    maxCol = Math.max(maxCol, colIdx);
                    for (; colIdx < 100; colIdx++) {
                        A[i][colIdx] = 0;
                    }
                }
                colSize = maxCol;
            } else {
                int maxRow = 0;
                for (int j = 0; j < colSize; j++) {
                    int[] count = new int[101];
                    for (int i = 0; i < rowSize; i++) {
                        if (A[i][j] == 0) continue;
                        count[A[i][j]]++;
                    }

                    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
                    for (int i = 1; i <= 100; i++) {
                        if (count[i] > 0) {
                            pq.add(new int[]{i, count[i]});
                        }
                    }

                    int rowIdx = 0;
                    while (!pq.isEmpty()) {
                        int[] cur = pq.poll();
                        A[rowIdx++][j] = cur[0];
                        A[rowIdx++][j] = cur[1];
                        if (rowIdx >= 100) break;
                    }
                    maxRow = Math.max(maxRow, rowIdx);
                    for (; rowIdx < 100; rowIdx++) {
                        A[rowIdx][j] = 0;
                    }
                }
                rowSize = maxRow;
            }
            time++;
        }
        System.out.println(-1);
    }
}
