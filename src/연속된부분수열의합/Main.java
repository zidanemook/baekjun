package 연속된부분수열의합;

import java.io.*;
import java.util.*;


class Solution {
    public int[] solution(int[] sequence, int k) {


        int left = 0;
        int right = 0;
        int temp = 0;
        int len = 1000000;
        int s = 0;
        int e = 0;
        for(int i = left; i <= right; ++i)
            temp += sequence[i];
        while(right < sequence.length && left <= right){

            if(temp > k){
                temp -= sequence[left];
                left++;
            }else if(temp < k){
                right++;
                if(right < sequence.length)
                    temp += sequence[right];
            }else{
                if(len > right-left){
                    len = right-left;
                    s = left;
                    e = right;
                }
                right++;
                if(right < sequence.length)
                    temp += sequence[right];
            }

        }

        int[] answer = new int[2];
        answer[0] = s;
        answer[1] = e;
        return answer;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] input = {1,2,3,4,5};
        int k = 7;
        int[] answer = sol.solution(input, k);

        for(int i:answer){
            System.out.print(i);
        }
    }
}
