package StackSequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) {

        FastReader fr = new FastReader();

        int cnt = fr.nextInt();

        ArrayList<Integer> stack = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> ret = new ArrayList<>();

        ArrayList<Integer> test = new ArrayList<>();

        int num = 1;
        int inNum = 0;

        boolean success = true;
        for(int i = 0; i < cnt; ++i) {
            inNum = Integer.parseInt(fr.nextLine());

            while (true)
            {
                if (stack.isEmpty() == true) {
                    if(num > cnt)
                    {
                        success = false;
                        break;
                    }

                    stack.add(num++);
                    sb.append("+\n");
                } else if (stack.get(stack.size()-1) < inNum) {
                    if(num > cnt)
                    {
                        success = false;
                        break;
                    }
                    stack.add(num++);
                    sb.append("+\n");
                } else if (stack.get(stack.size()-1) > inNum) {
                    test.add(stack.remove(stack.size()-1));
                    sb.append("-\n");
                } else if (stack.get(stack.size()-1) == inNum) {
                    test.add(stack.remove(stack.size()-1));
                    sb.append("-\n");
                    break;
                }
            }

        }
        if(success == false)
        {
            System.out.println("NO");
        }
        else
        {
            System.out.println(sb.toString());
        }


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
