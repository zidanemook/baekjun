package 터렛1002;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int[] T1 = new int[2];
            int[] T2 = new int[2];

            T1[0] = Integer.parseInt(st.nextToken());
            T1[1] = Integer.parseInt(st.nextToken());
            int R1 = Integer.parseInt(st.nextToken());

            T2[0] = Integer.parseInt(st.nextToken());
            T2[1] = Integer.parseInt(st.nextToken());
            int R2 = Integer.parseInt(st.nextToken());


            double d = Math.sqrt(Math.pow(T1[0]-T2[0],2) + Math.pow(T1[1]-T2[1],2));

            //두원 일치
            if(d==0 && R1 == R2){
                System.out.println(-1);
            }

            //서로 내부 한점
            else if(((d+R1) == R2) || ((d+R2) == R1)){
                System.out.println(1);
            }
            //서로 내부
            else if((d+R1) < R2 || (d+R2) < R1){
                System.out.println(0);
            }

            //서로 외부 한 점
            else if(d == (R1+R2)){
                System.out.println(1);
            }

            //서로 외부 두 점
            else if(d < (R1+R2)){
                System.out.println(2);
            }

            else if(d > R1+R2) {
                System.out.println(0);
            }

        }
    }
}
