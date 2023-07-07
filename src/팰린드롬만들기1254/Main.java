package 팰린드롬만들기1254;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();// 50

        if(true == isPal(input)){
            System.out.println(input.length());
            return;
        }

        //pal 인 부분 찾기
        int left = 0;// = input.length();
        while(left < input.length()-1){

            String temp = input.substring(left, input.length());
            if(isPal(temp)){
                break;
            }
            left++;
        }

        System.out.println(input.length()+left);
    }

    public static boolean isPal(String str){

        for (int i = 0; i < str.length()/2; i++) {

            if(str.charAt(i) != str.charAt(str.length()-1-i)){
                return false;
            }
        }

        return true;
    }
}
