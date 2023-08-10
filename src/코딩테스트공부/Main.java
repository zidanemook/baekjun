package 코딩테스트공부;

import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int targeAlp = alp;
        int targetCop = cop;
        for (int[] problem : problems) {
            targeAlp = Math.max(targeAlp, problem[0]);
            targetCop = Math.max(targetCop, problem[1]);
        }

        int[][] dp = new int[targeAlp + 1][targetCop + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[alp][cop] = 0;

        for (int i = alp; i <= targeAlp; ++i) {
            for (int j = cop; j <= targetCop; ++j) {
                if (dp[i][j] == Integer.MAX_VALUE) continue;//아직 dp[i][j] 는 탐색되지 않음 dp[i][j]를 기반으로 다음값을 찾을 수 없다

                //공부해서 올리기
                if (i < targeAlp) dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                if (j < targetCop) dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);

                for (int[] problem : problems) {
                    int areq = problem[0];
                    int creq = problem[1];
                    int arwd = problem[2];
                    int crwd = problem[3];
                    int cost = problem[4];
                    if (i >= areq && j >= creq) {
                        int newAlp = Math.min(i + arwd, targeAlp);
                        int newCop = Math.min(j + crwd, targetCop);
                        dp[newAlp][newCop] = Math.min(dp[newAlp][newCop], dp[i][j] + cost);
                    }
                }
            }
        }

        return dp[targeAlp][targetCop];
    }
}


public class Main {
    public static void main(String[] args) {

        Solution sol = new Solution();

        int alp = 0;
        int cop = 0;
        int[][] problems = {{0, 0, 2, 1, 2}, {4, 5, 3, 1, 2},{4, 11, 4, 0, 2},{10, 4, 0, 4, 2}};
        System.out.println(sol.solution(alp, cop, problems));
    }
}
