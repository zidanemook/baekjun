package 전화번호목록5052;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] arrstr = new String[n];

            for (int j = 0; j < n; j++) {
                arrstr[j] = br.readLine();
            }

            Arrays.sort(arrstr);

            boolean No = false;
            for (int j = 0; j < n; j++) {

                if((j+1) < n && arrstr[j+1].indexOf(arrstr[j]) == 0){
                    No = true;
                    break;
                }
            }
            if(No)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}
