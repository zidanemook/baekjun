package 이모티콘할인행사;

import java.util.*;

class Solution {

    static int[] salerates = {10, 20, 30, 40};

    static int[] answer = new int[2];

    static int[] salemix;

    static int maxSubscriptions = 0;
    static int maxSales = 0;

    public int[] solution(int[][] users, int[] emoticons) {

        salemix = new int[emoticons.length];


        dfs(0, users, emoticons);

        return answer;
    }

    public static void dfs(int depth, int[][] users, int[] emoticons){

        if(depth == emoticons.length)
        {
            int subscription = 0;

            int sales = 0;
            for (int[] user : users)
            {

                int cost = 0;
                for(int i = 0; i < emoticons.length; ++i){

                    if(salemix[i] < user[0])
                        continue;

                    cost += emoticons[i] * (100-salemix[i]) / 100;
                }

                if(cost >= user[1])
                    subscription++;
                else
                    sales += cost;
            }

            if(maxSubscriptions <= subscription){

                if(maxSubscriptions < subscription)
                    maxSales = 0;

                maxSubscriptions = subscription;

                if(maxSales < sales)
                    maxSales = sales;
            }

            answer[0] = maxSubscriptions;
            answer[1] = maxSales;

            return;
        }



        for(int i = 0; i < salerates.length; ++i){

            salemix[depth] = salerates[i];

            dfs(depth+1, users, emoticons);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] users = {{40, 10000},{25, 10000}};
        int[]  emoticons = {7000, 9000};

        int[] answer = sol.solution(users, emoticons);
        System.out.println(Arrays.toString(answer));
    }
}
