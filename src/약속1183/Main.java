package 약속1183;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = null;

        int max = 0;

        int[] difflist = new int[N];
        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            difflist[i] = a-b;
        }

        Arrays.sort(difflist);

        if(N%2==1)
            System.out.println(1);
        else
            System.out.println(Math.abs(difflist[N/2]-difflist[N/2-1])+1);

    }
}
