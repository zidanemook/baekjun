package 행운의문자열1342;

import java.io.*;
import java.util.*;

public class Main {

    static char[] inputarr = null;
    static int answer = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        if(input.length() == 1){
            System.out.println(1);
            return;
        }


        inputarr = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            inputarr[i] = input.charAt(i);
        }

        Arrays.sort(inputarr);

        char[] can = new char[input.length()];
        boolean[] visit = new boolean[input.length()];

        brute(0, can, visit);

        System.out.println(answer);
    }

    public static void brute(int depth, char[] can, boolean[] visit)
    {
        if(depth == inputarr.length){

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < inputarr.length; i++) {
                sb.append(can[i]);
            }

            int temp = 0;
            if(can[0] != can[1])
                temp++;

            if(can[inputarr.length-2] != can[inputarr.length-1])
                temp++;

            for (int i = 1; i < inputarr.length-1; i++) {
                if(can[i] != can[i+1] && can[i] != can[i-1])
                    temp++;
            }

            if(temp == inputarr.length)
                answer++;

            return;
        }

        for (int i = 0; i < inputarr.length; i++) {

            if(visit[i])
                continue;

            //if(depth>0 && can[depth-1] == inputarr[i]) continue;
            //동일한 문자의 중복된 방문을 방지하여 중복된 순열을 건너뜀
            if (i > 0 && inputarr[i] == inputarr[i - 1] && !visit[i - 1]) continue;

            visit[i] = true;
            can[depth] = inputarr[i];
            brute(depth+1, can, visit);
            visit[i] = false;
        }
    }
}
