package 문서검색1543;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String doc = br.readLine();

        String word = br.readLine();

        int j = 0;
        int ans = 0;
        int noBack = 0;
        for(int i = 0; i < doc.length(); ++i)
        {
            Character cur = doc.charAt(i);
            if( cur.equals(word.charAt(j)))
            {
                if(j == word.length()-1)
                {
                    ans++;
                    j = 0;
                    noBack = i+1;
                }
                else
                {
                    j++;
                }
            }
            else
            {
                i = i -(j -1);
                if(i < noBack)
                    i = noBack;

                j = 0;

                if( cur.equals(word.charAt(j)))
                {
                    j++;
                }
            }
        }

        System.out.println(ans);
    }
}
