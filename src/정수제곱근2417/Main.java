package 정수제곱근2417;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        double temp = Math.sqrt(n);
        long ans = (long)(temp);

        if((ans*ans) < n)
            ans++;

        System.out.println(ans);
    }
}
