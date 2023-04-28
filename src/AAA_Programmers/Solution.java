package AAA_Programmers;

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        if(numbers.length == 1)
            return Integer.toString(numbers[0]);

        boolean allzero = true;
        for(int i : numbers)
        {
            if(i != 0)
                allzero=false;
        }
        if(allzero)
            return "0";


        String[] strs = new String[numbers.length];
        for(int i = 0; i < numbers.length; ++i)
            strs[i] = Integer.toString(numbers[i]);

        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs, (a, b) -> {

            if(a.length() == b.length())
            {
                return b.compareTo(a);
            }

            StringBuilder sA = new StringBuilder();
            StringBuilder sB = new StringBuilder();
            sA.append(a);
            sA.append(b);
            sB.append(b);
            sB.append(a);

            for(int i = 0; i < sA.length(); ++i)
            {
                if(sA.charAt(i) < sB.charAt(i))
                    return 1;
                else
                    return -1;
            }

            return 0;
        });
        for(String ele : strs)
        {
            sb.append(ele);
        }

        answer = sb.toString();
        return answer;
    }
}
