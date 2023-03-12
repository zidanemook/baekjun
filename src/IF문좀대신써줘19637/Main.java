package IF문좀대신써줘19637;

import java.io.*;
import java.util.*;

class Nickname
{
    String name;
    int power;

    public Nickname(String name, int power) {
        this.name = name;
        this.power = power;
    }
}

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Nickname[] arrName = new Nickname[N];

        for(int i = 0; i < N; ++i)
        {
            input = br.readLine().split(" ");
            arrName[i] = new Nickname(input[0], Integer.parseInt(input[1]));
        }

        int left = 0;
        int right = arrName.length;
        int cand= 0;
        StringBuilder sb = new StringBuilder();

        int temp = 0;
        for(int i = 0; i < M; ++i)
        {
            temp = Integer.parseInt(br.readLine());
            left = 0;
            right = arrName.length;

            while(left <= right)
            {
                cand = (left + right)/2;

                if(temp <= arrName[cand].power)//
                {
                    right = cand-1;
                }
                else
                {
                    left = cand+1;
                }
            }

            sb.append(arrName[left].name + "\n");
        }

        System.out.println(sb);

    }
}
