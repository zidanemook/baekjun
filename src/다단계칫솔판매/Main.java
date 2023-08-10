package 다단계칫솔판매;

import java.util.*;

class Solution {

    final int price = 100;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        HashMap<String, String> map = new HashMap<>();
        HashMap<String, Integer> profitmap = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {

            if(referral[i].equals("-")){
                //do nothing
            }else
                map.put(enroll[i], referral[i]);

            profitmap.put(enroll[i], 0);
        }




        for (int i = 0; i < seller.length ; i++) {

            String cur = seller[i];

            int input = amount[i]*100;

            int toparent = 0;
            int profit = 0;
            while(true){
                toparent = input*10/100;
                if(toparent == 0)
                    profit = input;
                else
                    profit = input - toparent;

                int curmoney = profitmap.get(cur);
                profitmap.put(cur, curmoney + profit);

                if(toparent == 0)
                    break;

                if(map.containsKey(cur))
                    cur = map.get(cur);
                else
                    break;

                input = toparent;
            }
        }


        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++)
            answer[i] = profitmap.get(enroll[i]);
        return answer;
    }
}

public class Main {

    public static void main(String[] args) {

        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        Solution sol = new Solution();
        int[] answer = sol.solution(enroll, referral, seller, amount);

        Arrays.stream(answer).forEach(i-> System.out.println(i));
    }
}
