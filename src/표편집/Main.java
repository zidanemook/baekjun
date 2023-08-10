package 표편집;

import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {

        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> set = new HashSet<>();

        for(String com : cmd){

            String[] input = com.split(" ");

            if(input[0].equals("U")){
                int move = Integer.parseInt(input[1]);

                //k, k-move 사이에 삭제된게 있는가?
                //삭제된거 있으면 한번더 가야한다

                int target = Math.max(0, k-move);

                for (int i = target; i <= k; i++) {
                    if(set.contains(i))
                        target--;
                }

                k = Math.max(0, target);

            }else if(input[0].equals("D")){
                int move = Integer.parseInt(input[1]);

                //삭제된거 있는지 체크하고 움직여야한다

                int target = Math.min(n-1, k+move);

                for (int i = k; i <= target; i++) {
                    if(set.contains(i))
                        target++;
                }

                k = Math.min(n-1, target);

            }else if(input[0].equals("C")){

                stack.add(k);
                set.add(k);

                if(k == n-1){
                    k--;
                    while(set.contains(k)== true && k > 0)
                        k--;
                }

                else{
                    k++;
                    while(set.contains(k)==true && k < n-1)
                        k++;
                }


            }else if(input[0].equals("Z")){

                Integer pop = stack.pop();
                set.remove(pop);

            }

        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if(set.contains(i))
                sb.append("X");
            else
                sb.append("O");
        }

        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        int n = 3;
        int k = 1;
        String[] cmd = {"C", "C", "C", "Z", "Z", "Z"};
// 결과는 "OOO" 이어야 합니다.





        Solution sol = new Solution();

        String answer = sol.solution(n, k, cmd);

        System.out.println(answer);

    }
}
