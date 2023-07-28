package 사다리타기2469;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());//사람수 3 ~ 26
        int n = Integer.parseInt(br.readLine());//가로줄 3~1000

        String[] input;
        input = input = br.readLine().split("");

        char[] end = new char[k];
        for (int i = 0; i < input.length; i++) {
            end[i] = input[i].charAt(0);
        }

        char[] start = new char[k];
        for (int i = 0; i < k; i++) {
            start[i] = (char)('A'+i);
        }

        int[][] lines = new int[n][k-1];
        for (int i = 0; i < n; i++) {

            input = br.readLine().split("");
            for (int j = 0; j < k-1; j++) {

                if(input[j].equals("*")){
                    lines[i][j] = 0;
                }else if(input[j].equals("-")){
                    lines[i][j] = 1;
                }else{
                    lines[i][j] = 2;
                }
            }
        }

        boolean finish = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k-1; j++) {
                if(lines[i][j] == 1){
                    char temp = start[j];
                    start[j] = start[j+1];
                    start[j+1] = temp;
                }else if(lines[i][j] == 2){
                    finish = true;
                    break;
                }
            }
            if(finish)
                break;
        }

        finish = false;
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < k-1; j++) {
                if(lines[i][j] == 1){
                    char temp = end[j];
                    end[j] = end[j+1];
                    end[j+1] = temp;
                }else if(lines[i][j] == 2){
                    finish = true;
                    break;
                }
            }
            if(finish)
                break;
        }

        StringBuilder sb = new StringBuilder();
        boolean impossible = false;
        for (int i = 0; i < k-1; i++) {

            if (start[i] == end[i + 1] && start[i+1] == end[i]) {
                sb.append("-");
            }else if(start[i] == end[i] || (i > 0 && start[i] == end[i-1] && start[i-1] == end[i]))
                sb.append("*");
            else{
                impossible = true;
            }

        }

        if(impossible){
            sb.setLength(0);
            for (int i = 0; i < k - 1; i++) {
                sb.append("x");
            }
        }

        System.out.println(sb.toString());
    }
}
