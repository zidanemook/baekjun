package 카카오프렌즈컬러링북;

import java.util.LinkedList;
import java.util.Queue;

class Node
{
    int r;
    int c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Solution {

    public static void main(String[] args)
    {
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        solution(6, 4, picture);
    }

    static public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] visit = new boolean[m][n];

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if(visit[i][j] == false && picture[i][j] != 0)
                {
                    maxSizeOfOneArea = Math.max(bfs(picture, m, n, visit, new Node(i, j), picture[i][j]), maxSizeOfOneArea);
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    static public int bfs(int[][] picture, int m, int n, boolean[][] visit, Node start, int color)
    {
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        Queue<Node> que = new LinkedList<>();
        que.add(start);

        visit[start.r][start.c] = true;

        int count = 1;

        while(que.isEmpty() == false)
        {
            Node cur = que.poll();

            for (int i = 0; i < 4; i++)
            {
                int row = cur.r+dir[i][0];
                int col = cur.c+dir[i][1];

                if(row < 0 || row >= m || col < 0 || col >= n)
                    continue;

                if(visit[row][col])
                    continue;

                if(color != picture[row][col])
                    continue;

                que.add(new Node(row, col));
                visit[row][col] = true;
                count++;
            }
        }

        return count;
    }
}
