package 양궁대회;

import java.util.*;
class Solution {

    static int[] mix;
    static int maxoffset = 0;

    static int[] answer;
    public int[] solution(int n, int[] info) {

        mix = new int[10+1];
        answer = new int[10+1];

        brute(0, n, info, n);

        boolean allzero = true;
        for (int ans : answer){
            if(ans != 0){
                allzero = false;
                break;
            }
        }

        if(allzero || maxoffset == 0){
            int[] answer = {-1};
            return answer;
        }

        return answer;
    }

    public void brute(int depth, int n, int[] info, int arrow){

        if(depth == 11){

            int lionscore = 0;
            int peachscore = 0;

            for (int i = 0; i <= 10; i++) {
                if(mix[i] > 0 &&  info[i] < mix[i]){
                    lionscore += (10-i);
                }else if(info[i] > 0)
                    peachscore += (10-i);
            }

            int offset = lionscore - peachscore;

            if(maxoffset <= offset){

                if(maxoffset == offset)
                {
                    for (int i = 10; i >= 0; i--) {
                        if( answer[i] > 0 || mix[i] > 0 ){
                            if(answer[i] > mix[i])
                                return;
                            else if(answer[i] < mix[i])
                                break;
                        }
                    }
                }

                maxoffset = offset;
                answer = Arrays.copyOf(mix, mix.length);
            }

            return;
        }

        for (int i = 0; i <= 10; i++) {

            if(arrow >= i)
            {
                mix[depth] = i;
                brute(depth+1, n, info, arrow-i);
                mix[depth] = 0;
            }


        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int n = 5;
        int[] info = {2,1,1,1,0,0,0,0,0,0,0};
        int[] answer = sol.solution(n, info);

        for(int ans : answer){
            System.out.print(ans);
        }
        System.out.println();
    }
}
