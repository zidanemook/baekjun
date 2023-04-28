package 프렌즈4블록;
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();

        String[] input = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(solution.solution(4, 5, input));
    }
}



class Node
{
    int r;
    int c;
    char type;

    Node(int r, int c, char type)
    {
        this.r = r;
        this.c = c;
        this.type = type;
    }
}

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;

        int[][] pan = new int[m][n];
        int[][] delpan = new int[m][n];
        for(int i = 0; i < m; ++i)
        {
            for(int j = 0;j < n; ++j)
            {
                pan[i][j] = board[i].charAt(j)-'A';
            }
        }

        int[][] dir = {{0, 1},{1, 0},{1, 1}};//r, d, rd

        while(true)//더 지워질게 없을때까정 반복
        {
            //boolean[][] visit = new boolean[m][n];
            //ArrayList<Node> delist = new ArrayList<>();

            for(int i = 0; i < m; ++i)
            {
                for(int j = 0;j < n; ++j)
                {
                    if(pan[i][j] == -1)
                        continue;

                    boolean twobytwo = true;
                    for(int k = 0; k < 3; ++k)
                    {
                        int row = i+dir[k][0];
                        int col = j+dir[k][1];

                        if(row >= m || col >= n)
                        {
                            twobytwo = false;
                            break;
                        }

                        if(pan[i][j] != pan[row][col])
                        {
                            twobytwo = false;
                            break;
                        }
                    }
                    if(twobytwo)
                    {
                        delpan[i][j] = -1;
                        for(int k = 0; k < 3; ++k)
                        {
                            int row = i+dir[k][0];
                            int col = j+dir[k][1];
                            //if(row >= m || col >= n)
                            //    continue;
                            delpan[row][col] = -1;
                        }
                    }
                }
            }

            boolean existDel = false;
            for(int i = 0; i < m; ++i)
            {
                for(int j = 0;j < n; ++j)
                {
                    if(delpan[i][j] == -1)
                    {
                        pan[i][j] = -1;
                        delpan[i][j] = 0;
                        existDel = true;
                    }
                }
            }


            if(false == existDel)//2x2가 없으면 종료
            {
                //지워진 개수
                for(int i = 0; i < m; ++i)
                {
                    for(int j = 0;j < n; ++j)
                    {
                        if(-1 == pan[i][j])
                            answer++;
                    }
                }
                break;
            }

            //재배열
            for(int i = m-1; i >= 0; --i)
            {
                for(int j = 0;j < n; ++j)
                {
                    int down = i;
                    int up = down;
                    while(up >= 0)
                    {
                        if(pan[up][j] == -1)
                        {
                            up--;
                        }
                        else
                        {
                            if(down != up)
                            {
                                int temp = pan[up][j];
                                pan[up][j] = pan[down][j];
                                pan[down][j] = temp;
                            }

                            down--;
                            up--;
                        }

                    }
                }
            }



        }

        return answer;
    }


}