package 택배배달과수거하기;

import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int deliver = 0;//배달해야 할 상품의 양
        int pickup = 0;//수거해야 할 상품의 양
        long answer = 0;

        for (int i = n-1; i >= 0; i--)//역순으로 집을 방문하면서 배달과 수거를 진행
        {
            if(deliveries[i] != 0 || pickups[i] != 0){
                int cnt = 0;
                while (deliver < deliveries[i] || pickup < pickups[i]){
                    cnt++;//특정 집에 대한 방문 횟수
                    deliver += cap;//배달해야 할 상품이 충분하지 않으면 물류창고에서 새로운 상품을 cap만큼 더 가져옴
                    pickup += cap;//수거해야 할 상품이 충분하지 않으면 물류창고에서 새로운 상품을 cap만큼 더 가져옴
                }
                deliver -= deliveries[i];
                pickup -= pickups[i];
                answer += (i+1) * cnt * 2;//물류창고에서 집까지 거리 * 방문횟수 * 왕복
            }

        }
        return answer;
    }
}
public class Main {

    public static void main(String[] args) {

        Solution sol = new Solution();
        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups = {0, 3, 0, 4, 0};
        long answer = sol.solution(4, 5, deliveries, pickups);

        System.out.println(answer);
    }


}
