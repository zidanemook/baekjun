package 두수의합3273;

import java.io.*;
import java.util.Arrays;


public class Main
{
    //static int testcode = 0;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < arr.length; ++i)
        {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        int x = Integer.parseInt(br.readLine());
        int ans = 0;

        int lp = 0;
        int rp = arr.length-1;
        int sum = 0;
        while(lp < rp)
        {
            sum = arr[lp] + arr[rp];
            if(sum > x)
            {
                rp--;
            }
            else if(sum < x)
            {
                lp++;
            }
            else
            {
                rp--;
                lp++;
                ans++;
            }
            //testcode++;
        }

        System.out.println(ans);
        //System.out.println(testcode);
    }
}
