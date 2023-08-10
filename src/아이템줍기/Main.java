package 아이템줍기;

import java.util.*;
class Solution {

    final int maxsize = 120;
    int answer = 0;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        int[][] map = new int[maxsize][maxsize];

        for(int[] rec : rectangle){

            int lx = rec[0];
            int ly = rec[1];
            int rx = rec[2];
            int ry = rec[3];

            lx*=2;
            ly*=2;
            rx*=2;
            ry*=2;

            for (int i = lx; i <= rx; i++) {
                for (int j = ly; j <= ry; j++) {
                    map[i][j] = 1;
                }
            }
        }

        int[] character = new int[2];
        character[0] = characterX*2;
        character[1] = characterY*2;
        int[] item = new int[2];
        item[0] = itemX*2;
        item[1] = itemY*2;

        int answer = gogo(character, item, map);

        answer = (int)Math.ceil(answer/2f);

        return answer;
    }

    public int gogo(int[] start, int[] end, int[][] map){
        boolean[][] visit = new boolean[maxsize][maxsize];

        Queue<int[]> que = new LinkedList<>();

        que.add(start);
        visit[start[0]][start[1]] = true;

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int[][] edir = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

        boolean find = false;
        while(que.isEmpty() == false) {

            int[] cur = que.poll();

            for (int i = 0; i < 4; ++i) {
                int nx = cur[0] + dir[i][0];
                int ny = cur[1] + dir[i][1];

                if(map[nx][ny] == 0)
                    continue;

                if(visit[nx][ny] == true)
                    continue;

                boolean isBoarder = false;
                for (int j = 0; j < 8; ++j) {
                    int nnx = nx + edir[j][0];
                    int nny = ny + edir[j][1];

                    if(map[nnx][nny] == 0){
                        isBoarder = true;
                        break;
                    }
                }

                if(false == isBoarder)
                    continue;

                if(nx == end[0] && ny == end[1]){
                    find = true;
                    break;
                }

                visit[nx][ny] = true;
                int[] nei = new int[2];
                nei[0] = nx;
                nei[1] = ny;
                que.add(nei);
                answer++;
            }

            if(find)
                break;
        }


        answer = (int)Math.ceil(answer/2f);

        return answer;
    }

}

public class Main {
    public static void main(String[] args) {
        int[][] rectangle = {
                {1, 1, 8, 4},
                {2, 2, 4, 9},
                {3, 6, 9, 8},
                {6, 3, 7, 7}
        };
        int characterX = 9;
        int characterY = 7;
        int itemX = 6;
        int itemY = 1;

        Solution sol = new Solution();
        int result = sol.solution(rectangle, characterX, characterY, itemX, itemY);
        System.out.println("Result: " + result);
    }
}
