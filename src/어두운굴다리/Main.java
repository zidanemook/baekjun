package 어두운굴다리;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());//굴다리 길이
        int M = Integer.parseInt(br.readLine());//가로등개수

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] stand = new int[M];
        for(int i = 0; i < M; ++i)
        {
            stand[i] = Integer.parseInt(st.nextToken());
        }

        //첫가로등 왼쪽, 마지막 가로등오른쪽 거리. 가로등 사이의 거리/2. 중에서 가장 큰거 찾기

        int maxdiff = 0;
        int left = stand[0];
        maxdiff = Math.max(maxdiff, left);
        int right = N - stand[M-1];
        maxdiff = Math.max(maxdiff, right);

        for(int i = 0; i < M; ++i)
        {
            if((i+1) < M)
            {
                int diff = stand[i+1] - stand[i];
                if(diff%2 ==1)
                    maxdiff = Math.max(maxdiff, diff/2+1);
                else
                    maxdiff = Math.max(maxdiff, diff/2);
            }
        }

        System.out.println(maxdiff);
    }
}
