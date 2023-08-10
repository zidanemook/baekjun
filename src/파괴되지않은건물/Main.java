package 파괴되지않은건물;

import java.util.*;

class Solution {


    public int solution(int[][] board, int[][] skill) {
        int N = board.length;
        int M = board[0].length;
        int[][] prefixSum = new int[N][M];

        // 스킬 적용
        for (int[] s : skill) {
            int type = s[0], r1 = s[1], c1 = s[2], r2 = s[3], c2 = s[4], degree = s[5];
            if (type == 1) { // 공격인 경우
                degree = -degree;
            }
            // Prefix Sum 적용
            prefixSum[r1][c1] += degree;
            if (r2 + 1 < N) prefixSum[r2 + 1][c1] -= degree;
            if (c2 + 1 < M) prefixSum[r1][c2 + 1] -= degree;
            if (r2 + 1 < N && c2 + 1 < M) prefixSum[r2 + 1][c2 + 1] += degree;
        }

        // 최종 내구도 계산
        int intactBuildings = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i > 0) prefixSum[i][j] += prefixSum[i - 1][j];
                if (j > 0) prefixSum[i][j] += prefixSum[i][j - 1];
                if (i > 0 && j > 0) prefixSum[i][j] -= prefixSum[i - 1][j - 1];
                // 내구도가 1 이상인 건물 카운트
                if (board[i][j] + prefixSum[i][j] > 0) {
                    intactBuildings += 1;
                }
            }
        }

        return intactBuildings;
    }

}

public class Main {
    public static void main(String[] args) {

    }
}
