package 팰린드롬만들기1213;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        //전부짝수 or 하나만 홀수
        int[] alpha = new int[26];

        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            int j = cur-'A';
            alpha[j]++;
        }

        int oddcnt = 0;
        for (int i = 0; i < 26; i++) {
            if(alpha[i]%2 != 0)
                oddcnt++;

            if(oddcnt > 1)
            {
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        char oddchar = ' ';
        for (int i = 0; i < 26; i++) {
            if(alpha[i] > 0){

                int len = alpha[i];
                if(len%2 == 1)
                    len--;
                for (int j = 0; j < len/2; j++) {
                    sb.append((char)(i+'A'));
                }

            }

            if(alpha[i] %2 == 1)
                oddchar = (char)(i+'A');
        }


        StringBuilder answer = new StringBuilder();
        answer.append(sb);

        if(oddchar != ' ')
            sb.append(oddchar);

        answer.append(sb.reverse());

        System.out.println(answer);
    }
}
