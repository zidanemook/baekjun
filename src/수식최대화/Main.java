package 수식최대화;

import java.util.*;

class Solution {

    ArrayList<Long> arrnum;
    ArrayList<Character> op;


    public long solution(String expression) {

        StringBuilder sb = new StringBuilder();

        arrnum = new ArrayList<>();
        op = new ArrayList<>();

        for(int i = 0; i < expression.length(); ++i)
        {
            char c = expression.charAt(i);
            if(isNum(c))
            {
                sb.append(c);
            }
            else
            {
                op.add(c);
                arrnum.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
            }
        }
        arrnum.add(Long.parseLong(sb.toString()));

        //+-*
        char[][] seq = {{'+','-','*'},{'+','*','-'},{'-','+','*'},{'-','*','+'},{'*','+','-'},{'*','-','+'}};

        long maxmoney = 0;

        for(int i = 0; i < 6; ++i)
        {
            List<Long> tempNums = new ArrayList<>(arrnum);
            List<Character> tempOps = new ArrayList<>(op);

            for(int j = 0; j < 3; ++j)
            {
                char curop = seq[i][j];
                for(int k = 0; k < tempOps.size(); ++k)
                {
                    if(tempOps.get(k)== curop)
                    {
                        long a = tempNums.remove(k);
                        long b = tempNums.remove(k);
                        tempOps.remove(k);
                        long ret = 0;
                        if(curop == '+')
                            ret = a+b;
                        else if(curop=='-')
                            ret = a-b;
                        else
                            ret = a*b;
                        tempNums.add(k, ret);
                        k--;
                    }
                }
            }
            maxmoney = Math.max(maxmoney, Math.abs(tempNums.get(0)));
        }

        return maxmoney;
    }

    public boolean isNum(char c)
    {
        if(c >= '0' && c <= '9')
            return true;
        return false;
    }
}

public class Main {
    public static void main(String[] args) {

        String exp = "6*3-1";
        Solution sol = new Solution();
        System.out.println(sol.solution(exp));

    }
}
