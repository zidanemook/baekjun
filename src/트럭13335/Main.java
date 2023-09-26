package 트럭13335;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());//트럭수
        int W = Integer.parseInt(st.nextToken());//다리길이
        int L = Integer.parseInt(st.nextToken());//최대하중

        st = new StringTokenizer(br.readLine(), " ");
        int[] truck = new int[N];
        for (int i = 0; i < N; i++) {
            truck[i] = Integer.parseInt(st.nextToken());
        }

        int cweight = 0;
        int[] bridge = new int[W];
        int tid = 0;

        int answer = 0;
        while(tid < N)
        {
            if(bridge[0] != 0)
            {
                cweight -= bridge[0];
                bridge[0] = 0;
            }

            for (int i = 0; i < W - 1; i++) {
                bridge[i] = bridge[i+1];
            }
            bridge[W-1] = 0;

            if(tid < N && (cweight + truck[tid]) <= L){
                bridge[W-1] = truck[tid];
                cweight += truck[tid];
                tid++;
            }

            answer++;
        }

        System.out.println(answer+W);
    }
}
