package PostfixExpression1935;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args)
    {
        FastReader fr = new FastReader();

        int cnt = fr.nextInt();

        String expression = fr.nextLine();

        int idx = 0;
        ArrayList<Integer> arrList = new ArrayList<>();

        for(int i = 0; i < cnt; ++i)
        {
            arrList.add(Integer.parseInt(fr.nextLine()));
        }

        ArrayList<String> stack = new ArrayList<>();
        for(int i = 0; i < expression.length(); ++i)//대문자 알파벳
        {
            if('A' <= expression.charAt(i) && 'Z' >= expression.charAt(i))
            {
                int num = arrList.get(expression.charAt(i)-'A');
                stack.add(String.format("%d", num));
            }
            else
            {
                stack.add(String.valueOf(expression.charAt(i)));
            }
        }

        ArrayList<String> stacktwo = new ArrayList<>();

        String str1 = "";
        String str2 = "";
        Double num = 0.0;
        for(int i = 0; i < stack.size(); ++i)
        {
            if(stack.get(i).equals("+"))
            {
                str1 = stacktwo.remove(stacktwo.size()-1);
                str2 = stacktwo.remove(stacktwo.size()-1);
                num = Double.parseDouble(str1) + Double.parseDouble(str2);
                stacktwo.add(num.toString());
            }
            else if(stack.get(i).equals("-"))
            {
                str1 = stacktwo.remove(stacktwo.size()-1);
                str2 = stacktwo.remove(stacktwo.size()-1);
                num = Double.parseDouble(str2) - Double.parseDouble(str1);
                stacktwo.add(num.toString());
            }
            else if(stack.get(i).equals("*"))
            {
                str1 = stacktwo.remove(stacktwo.size()-1);
                str2 = stacktwo.remove(stacktwo.size()-1);
                num = Double.parseDouble(str2) * Double.parseDouble(str1);
                stacktwo.add(num.toString());
            }
            else if(stack.get(i).equals("/"))
            {
                str1 = stacktwo.remove(stacktwo.size()-1);
                str2 = stacktwo.remove(stacktwo.size()-1);
                num = Double.parseDouble(str2) / Double.parseDouble(str1);
                stacktwo.add(num.toString());
            }
            else
            {
                stacktwo.add(stack.get(i));
            }
        }

        System.out.printf("%.2f", Double.parseDouble(stacktwo.get(0)));

    }

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
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
                catch(IOException e)
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

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

    }
}
