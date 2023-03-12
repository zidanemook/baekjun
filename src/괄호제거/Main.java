package 괄호제거;
import java.io.*;
import java.util.*;

public class Main
{

    public static void main(String[] args)
    {
        FastReader fr = new FastReader();

        String command = fr.nextLine();

        HashMap<Integer, Integer> map = new HashMap<>();

        ArrayList<Integer> keyList = new ArrayList<>();

        for(int i = 0; i < command.length(); ++i)
        {
            if(command.charAt(i) == '(')
                keyList.add(i);
            else if(command.charAt(i) == ')')
            {
                int key = keyList.remove(keyList.size()-1);
                map.put(key, i);
            }
        }

        int pairCnt = map.size();
        int pairCntCopy = pairCnt-1;
        int max = (int)Math.pow(2, pairCnt);

        StringBuilder sb = new StringBuilder();
        HashSet<Integer> renderKey = new HashSet<>();
        HashSet<String> hash = new HashSet<>();
        for(int i = max-2; i >= 0; --i)
        {
            sb.setLength(0);
            renderKey.clear();
            pairCntCopy = pairCnt-1;
            for(int key : map.keySet())
            {
                int cur = (int)Math.pow(2, pairCntCopy);
                if((i & cur) != 0)
                {
                    renderKey.add(key);
                    renderKey.add(map.get(key));
                }

                pairCntCopy--;
            }

            for(int j = 0; j < command.length(); ++j)
            {
                if(command.charAt(j) == '(' || command.charAt(j) == ')')
                {
                    if(renderKey.contains(j) == false)
                        continue;
                }

                sb.append(command.charAt(j));
            }

            sb.append("\n");

            if(false == hash.contains(sb.toString()))
            {
                hash.add(sb.toString());
            }

        }
        hash.stream().sorted((s1, s2) -> s1.compareTo(s2)).forEach(s -> System.out.print(s));

    }

    static class FastReader
    {
        BufferedReader br;
        FastReader()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextLine()
        {
            String str = "";

            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }

    }
}
