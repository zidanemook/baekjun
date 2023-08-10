package 사라지는발판;

import java.util.*;
class Solution {

    int[] dx = {-1, 0, 1, 0};//row
    int[] dy = {0, 1, 0, -1};//col
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        Result result = doGame(board, aloc, bloc, 0);
        return result.move;
    }

    private Result doGame(int[][] board, int[] aloc, int[] bloc, int depth) {
        if (board[aloc[0]][aloc[1]] == 0)//발판 없어서 패배
        {
            return new Result(false, depth);
        }
        boolean canMove = false;
        boolean canWin = false;
        int minMove = (int) 1e9, maxMove = 0;
        for (int i = 0; i < 4; i++) {
            int nx = aloc[0] + dx[i];
            int ny = aloc[1] + dy[i];
            if (0 <= nx && nx < board.length && 0 <= ny && ny < board[0].length && board[nx][ny] != 0) {
                canMove = true;
                int[] newloc = {nx, ny};
                board[aloc[0]][aloc[1]] = 0;
                Result result = doGame(board, bloc, newloc, depth + 1);//true 반환하면 canWin 은 false
                canWin |= !result.win;// canWin 한번 true 되면 변하지 않는다. 이기는 상황에서 최대한 빨리 움직이는 모든 경우를 찾기위함
                if (result.win)//패배하는 상황에서는 최대한 많이 움직이는거 선택
                {
                    maxMove = Math.max(maxMove, result.move);
                } else//이기는 상황에서는 최대한 빨리 움직이는거 선택
                {
                    minMove = Math.min(minMove, result.move);
                }
                board[aloc[0]][aloc[1]] = 1;
            }
        }
        if (!canMove)//움직일 방향이 없어서 패배
        {
            return new Result(false, depth);
        }
        return new Result(canWin, canWin ? minMove : maxMove);
    }

    private static class Result {
        boolean win;
        int move;

        public Result(boolean win, int move) {
            this.win = win;
            this.move = move;
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Solution sol = new Solution();

        int[][] board = {{1,1,1},{1,1,1},{1,1,1}};
        int[] aloc = {1,0};
        int[] bloc = {1,2};
        System.out.println(sol.solution(board, aloc, bloc));
    }
}
