package 나는야포켓몬마스터이다솜1620;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        FastReader fr = new FastReader();
        String[] input = fr.nextLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        HashMap<String, Integer> monName = new HashMap<>();
        HashMap<Integer, String> monNum = new HashMap<>();
        //ArrayList<String> answer = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; ++i)
        {
            String name = fr.nextLine();
            monName.put(name, i+1);
            monNum.put(i+1, name);
        }
        for(int i = 0; i < M; ++i)
        {
            String tmp = fr.nextLine();
            if(Character.isDigit(tmp.charAt(0)))
            {
                sb.append(monNum.get(Integer.parseInt(tmp)));
            }
            else
            {
                sb.append(monName.get(tmp));
            }

            if(i != M-1)
                sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        FastReader()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next()
        {
            while(st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

    }
}
