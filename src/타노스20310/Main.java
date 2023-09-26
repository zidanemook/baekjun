package 타노스20310;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split("");

        int zcnt = 0;
        int ocnt = 0;
        for (int i = 0; i < input.length; i++) {

            if(input[i].equals("0"))
                zcnt++;
            else
                ocnt++;

        }

        zcnt/=2;

        int halfocnt = ocnt/2;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length; i++) {

            if(input[i].equals("0") && zcnt > 0)
            {
                sb.append("0");
                zcnt--;
            }
            else if(ocnt>halfocnt)
            {
                ocnt--;
            }
            else
            {
                sb.append("1");
                ocnt--;
                halfocnt--;
            }

            if(zcnt == 0 && ocnt == 0)
                break;
        }

        System.out.println(sb);
    }
}
