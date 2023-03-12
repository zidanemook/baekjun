package 두개의탑2118;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; ++i)
        {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int rab = 1;
        int tur = 0;
        int rabhead = arr[0];
        int turhead = 0;
        for(int i = 1; i < N; ++i)
        {
            turhead += arr[i];
        }

        int max = Integer.MIN_VALUE;

        while(tur < N)
        {

            if(rabhead <= turhead)
            {
                rabhead += arr[rab];
                turhead -= arr[rab];

                rab++;
                if(rab >= N)
                    rab = 0;
            }
            else
            {
                turhead += arr[tur];
                rabhead -= arr[tur];

                tur++;
                //if(tur >= N)
                //    tur = 0;
            }

            max = Math.max(max, Math.min(rabhead, turhead));
        }

        System.out.println(max);
    }
}
