package AC5430;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());//~100

        for (int i = 0; i < t; i++) {

            String[] input = br.readLine().split("");

            //1 ~ 100000
            char[] function = new char[input.length];
            for (int j = 0; j < input.length; j++) {
                function[j] = input[j].charAt(0);
            }

            int n = Integer.parseInt(br.readLine());//0~100000
            int num = 0;
            ArrayList<Integer> arr = new ArrayList<>();
            input = br.readLine().split("");
            for (int j = 0; j < input.length; j++) {
                if(isNum(input[j].charAt(0))){
                    num = num*10 + Integer.parseInt(input[j]);
                }else if(num != 0){
                    arr.add(num);
                    num = 0;
                }
            }

            int left = 0;
            int right = arr.size()-1;
            boolean isLeft = true;

            boolean error = false;
            for (int j = 0; j < function.length; j++) {

                if(function[j] == 'R'){
                    isLeft = !isLeft;
                }else{

                    if(left > right){
                        error = true;
                        break;
                    }

                    if(isLeft){
                        left++;
                    }else{
                        right--;
                    }
                }
            }

            if(error)
                System.out.println("error");
            else{

                StringBuilder sb = new StringBuilder();

                if(left == right){
                    sb.append("["+arr.get(left)+"]");
                }else {

                    if(isLeft){
                        for (int j = left; j <= right; j++) {
                            if(j== left){
                                sb.append("[" + arr.get(j));
                            }else if(j == right){
                                sb.append("," + arr.get(j) + "]");
                            }else{
                                sb.append("," + arr.get(j));
                            }
                        }
                    } else {

                        for (int j = right; j >= left; j--) {
                            if (j == right) {
                                sb.append("[" + arr.get(j));
                            } else if (j == left) {
                                sb.append("," + arr.get(j) + "]");
                            } else {
                                sb.append("," + arr.get(j));
                            }
                        }

                    }
                }

                if(sb.length() == 0)
                    sb.append("[]");

                System.out.println(sb.toString());
            }
        }

    }
    public static boolean isNum(char c){
        if(c - '0' >= 0 && c-'0'<=9)
            return true;

        return false;
    }
}
