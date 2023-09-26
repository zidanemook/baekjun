package 비슷한단어2607;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] word = new String[n];
        int[] alphabet = new int[26];
        for(int i = 0; i < n; ++i)
        {
            word[i] = br.readLine();
        }

        for(int i = 0; i < word[0].length(); ++i)
        {
            char cur = word[0].charAt(i);
            alphabet[cur-'A']++;
        }
        int answer = 0;

        for(int i = 1; i < word.length; ++i)
        {
            int[] cnt = new int[26];

            String curstr = word[i];
            for(int j = 0; j < curstr.length(); ++j)
            {
                char cur = curstr.charAt(j);
                cnt[cur-'A']++;
            }

            int allow = 1;//허용 오차
            int diff = 0;
            boolean same = true;

            if(word[0].length() == curstr.length())
            {
                int minus = 0;
                int plus = 0;
                for(int j = 0; j < 26; ++j)
                {
                    int temp = cnt[j]-alphabet[j];

                    if(temp < 0)
                        minus+=temp;
                    else if(temp > 0)
                        plus+=temp;
                    if(Math.abs(minus) > 1 || Math.abs(plus) > 1)
                    {
                        same = false;
                        break;
                    }
                }
            }
            else
            {
                for(int j = 0; j < 26; ++j)
                {
                    int temp = cnt[j]-alphabet[j];

                    temp = Math.abs(temp);
                    if(temp > 0)
                    {
                        allow -= temp;
                        if(allow < 0)
                        {
                            same = false;
                            break;
                        }
                    }
                }
            }

            if(same)
                answer++;
        }

        System.out.println(answer);
    }
}
