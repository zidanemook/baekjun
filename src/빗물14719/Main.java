package 빗물14719;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] block = new int[H][W];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < W; i++) {
            int height = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for(int j = H-1; j >= 0; j--)
            {
                if(cnt >= height)
                    break;
                block[j][i] = 1;
                cnt++;

            }
        }

        boolean[][] visit = new boolean[H][W];
        //낮은곳부터 물 담을 수 있는지 탐색
        for (int i = 0; i < W; i++) {

            for (int j = H-1; j >= 0; j--) {

                if(block[j][i] != 0)
                    continue;

                if(visit[j][i])
                    continue;

                //왼쪽 탐색 벽있는지
                boolean leftwall = false;
                int leftwallpos = 0;
                int col = i;
                while(col>=0)
                {
                    visit[j][col] = true;
                    if(block[j][col] == 1)
                    {
                        leftwall = true;
                        leftwallpos = col;
                        break;
                    }
                    col--;
                }

                //오른쪽 탐색 벽있는지
                boolean rightwall = false;
                int rightwallpos = 0;
                col = i;
                while(col < W)
                {
                    visit[j][col] = true;
                    if(block[j][col] == 1)
                    {
                        rightwall = true;
                        rightwallpos = col;
                        break;
                    }
                    col++;
                }

                if(leftwall && rightwall)
                {
                    for (int k = leftwallpos+1; k < rightwallpos; k++) {
                        block[j][k] = 2;

                    }
                }

            }
        }

        int answer = 0;
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                if(block[j][i] == 2)
                    answer++;
            }
        }

        System.out.println(answer);
    }
}
