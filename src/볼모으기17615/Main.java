package 볼모으기17615;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String input = br.readLine();

        //파란색 옮기는 경우 횟수 구하기
        int bmovecnt = 0;
        int bmincnt = 1000000;

        //왼쪽
        int leftredball = 0;
        for (int i = 0; i < input.length(); i++) {
            if('B' == input.charAt(i) && leftredball > 0)
                bmovecnt++;

            if('R' == input.charAt(i))
                leftredball++;
        }
        bmincnt = Math.min(bmincnt, bmovecnt);
        bmovecnt = 0;


        //오른쪽
        int rightredball = 0;
        for (int i = input.length()-1; i >= 0; i--) {
            if('B' == input.charAt(i) && rightredball > 0)
                bmovecnt++;

            if('R' == input.charAt(i))
                rightredball++;
        }
        bmincnt = Math.min(bmincnt, bmovecnt);


        //빨간볼 옮기는 경우 구하기

        int rmovecnt = 0;
        int rmincnt = 1000000;

        //왼쪽
        int leftblueball = 0;
        for (int i = 0; i < input.length(); i++) {
            if('R' == input.charAt(i) && leftblueball > 0)
                rmovecnt++;

            if('B' == input.charAt(i))
                leftblueball++;
        }
        rmincnt = Math.min(rmincnt, rmovecnt);
        rmovecnt = 0;

        //오른쪽
        int rightblueball = 0;
        for (int i = input.length()-1; i >= 0 ; i--) {
            if('R' == input.charAt(i) && rightblueball > 0)
                rmovecnt++;

            if('B' == input.charAt(i))
                rightblueball++;
        }
        rmincnt = Math.min(rmincnt, rmovecnt);

        System.out.println(Math.min(bmincnt, rmincnt));
    }
}
