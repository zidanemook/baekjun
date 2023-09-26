package 드래곤커브;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = null;

        boolean[][] map = new boolean[101][101];

        for(int i = 0; i < n; ++i)
        {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            List<Integer> directions = new ArrayList<>();
            directions.add(d);

            //방향 정보만 저장함
            for (int j = 0; j < g; j++) {
                for (int k = directions.size() - 1; k >= 0; k--) {
                    directions.add((directions.get(k) + 1) % 4);
                }
            }

            map[x][y] = true;
            for (int dir : directions) {
                if (dir == 0) x++;
                else if (dir == 1) y--;
                else if (dir == 2) x--;
                else if (dir == 3) y++;

                map[x][y] = true;
            }
        }


        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) {
                    count++;
                }
            }
        }

        System.out.println(count);

    }


}
