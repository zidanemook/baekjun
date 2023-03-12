package 전화번호목록5052;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        TreeSet<String> tree = new TreeSet<>();
        StringBuilder sb = new StringBuilder();

        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < t; ++i)
        {
            tree.clear();
            int n = Integer.parseInt(br.readLine());

            for(int j = 0; j < n; ++j)
            {
                tree.add(br.readLine());
            }

            boolean same = false;
            for(String el : tree)
            {
                if(sb.length() != 0)
                {
                    if(sb.length() >= el.length())
                    {
                        sb.setLength(el.length());
                        if(sb.toString().equals(el))
                        {
                            same = true;
                            break;
                        }

                    }
                    else
                    {
                        if(sb.toString().equals(el.substring(0, sb.length())))
                        {
                            same = true;
                            break;
                        }
                    }
                }

                sb.setLength(0);
                sb.append(el);
            }

            sb.setLength(0);

            if(same == false)
            {
                ans.append("YES\n");
            }
            else
            {
                ans.append("NO\n");
            }
        }

        System.out.println(ans);
    }
}
