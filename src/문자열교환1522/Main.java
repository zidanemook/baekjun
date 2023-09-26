package 문자열교환1522;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int acnt = 0;
        for (int i = 0; i < input.length(); i++) {

            if(input.charAt(i) == 'a')
                acnt++;
        }

        int left = 0;
        int change = 100000000;
        for (int i = 0; i < input.length(); i++){

            int idx = left;
            int tempchange = 0;
            for (int j = 0; j < acnt; j++) {

                if(input.charAt(idx) != 'a')
                    tempchange++;
                idx++;
                idx%=input.length();
            }
            change = Math.min(change, tempchange);

            left++;
        }
        System.out.println(change);
    }
}
