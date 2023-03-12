package 생태학4358;

import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        TreeMap<String, Integer> map = new TreeMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tree = "";
        int total = 0;

        while(true) {

            tree = br.readLine();
            if(tree == null || tree.equals("exit"))
                break;

            if(map.containsKey(tree))
            {
                map.put(tree.toString(), map.get(tree)+1);
            }
            else
            {
                map.put(tree.toString(), 1);
            }
            total++;
        }

        StringBuilder sb = new StringBuilder();

        for(String key : map.keySet())
        {
            sb.append(key + " " + String.format("%.4f", 100f * (float)map.get(key)/(float)total) + "\n");
        }

        System.out.println(sb.toString());
    }
}