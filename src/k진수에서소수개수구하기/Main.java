package k진수에서소수개수구하기;

import java.util.*;

class Solution {
    public int solution(int n, int k) {

        List<Integer> list = new ArrayList<>();
        while(n>=k){

            list.add(n%k);
            n/=k;
        }
        list.add(n);
        Collections.reverse(list);

        StringBuilder sb = new StringBuilder();
        for(int i : list){
            sb.append(i);
        }

        String[] num = sb.toString().split("0");

        int answer = 0;

        for(String ele : num){

            if(ele.isEmpty()==false && isPrime(ele))
                answer++;

        }

        return answer;
    }

    public boolean isPrime(String num){

        long n = Long.parseLong(num);

        if(n < 2)
            return false;

        for(Long i = 2L; i <= Math.sqrt(n); ++i){

            if(n%i == 0)
                return false;
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {

        Solution sol = new Solution();

        int n = 437674;
        int k = 3;

        System.out.println(sol.solution(n, k));
    }
}
