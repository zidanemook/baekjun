package 줄서는방법;

import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        //4, 1 1234
        //4, 9 2314
        //3, 5 312
        //3, 6 321
        //5, 120L 54321
        //20, 2432902008176640000L   20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1
        Arrays.stream(sol.solution(20, 2432902008176640000L)).forEach( i -> System.out.print(i+" "));
    }
}

class Solution {

    public int[] solution(int n, long k) {
        int[] answer = {};

        answer = new int[n];

        List<Integer> num = new ArrayList<>();
        for(int i = 1; i <= n; ++i) {
            num.add(i);
        }

        long[] total = new long[n+1];
        total[1] = 1L;
        for(int i = 2; i <= n; ++i)
        {
            total[i] = i * total[i-1];
        }

        double div = n;
        long nk = k;
        for(int i = 0; i < n; ++i)
        {
            int idx = (int)Math.ceil(nk*div/total[n-i])-1;
            answer[i] = num.get(idx);
            num.remove(idx);

            div--;
            if(n-i-1 == 0)
                break;
            nk %= total[n-i-1];

            if(nk < 1)
                nk = total[n-i-1];
        }

        return answer;
    }
}
