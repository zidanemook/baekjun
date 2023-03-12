package 괄호의값2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {

        FastReader fr = new FastReader();
        String parentheses = fr.nextLine();

        //홀수면 비정상
        if(parentheses.isEmpty() ||parentheses.length() % 2 == 1) {
            System.out.println(0);
            return;
        }

        ArrayList<String> stack = new ArrayList<>();

        int cidx = 0;
        while(cidx < parentheses.length())
        {
            String cur = Character.toString(parentheses.charAt(cidx));
            if(cur.equals("(") || cur.equals("["))
            {
                stack.add(cur);
            }
            else if(cidx > 0)// ) or ]
            {
                String prev = Character.toString(parentheses.charAt(cidx-1));
                if(prev.equals("(") && cur.equals(")"))
                {
                    stack.remove(stack.size()-1);
                    stack.add("2");
                }
                else if(prev.equals("[") && cur.equals("]"))
                {
                    stack.remove(stack.size()-1);
                    stack.add("3");
                }
                else if(prev.equals(")") || prev.equals("]"))//prev ) or ]
                {
                    int match = 1;//스택에서 매칭되는 괄호 찾기
                    if(cur.equals(")"))
                    {
                        Integer sum =0;
                        int i = stack.size()-1;
                        while(match!= 0 && (i >= 0))
                        {
                            if(stack.get(i).equals(")") )
                                match++;
                            else if(stack.get(i).equals("("))
                                match--;
                            else if(stack.get(i).equals("[") || stack.get(i).equals("]"))
                            {}
                            else
                            {
                                sum += Integer.parseInt(stack.remove(i));
                            }

                            i--;
                        }
                        if(match!=0)
                        {
                            stack.clear();
                            break;
                        }

                        sum *= 2;//'(',')' 를 없애면서 안에 있었던 숫자와 곱하기

                        stack.remove(stack.size()-1);
                        stack.add(sum.toString());
                    }

                    else if(cur.equals("]"))
                    {
                        Integer sum =0;
                        int i = stack.size()-1;
                        while((match!= 0) && (i >= 0))
                        {
                            if(stack.get(i).equals("]") )
                                match++;
                            else if(stack.get(i).equals("["))
                                match--;
                            else if(stack.get(i).equals("(") || stack.get(i).equals(")"))
                            {}
                            else
                            {
                                sum += Integer.parseInt(stack.remove(i));
                            }
                            i--;
                        }

                        if(match!=0)
                        {
                            stack.clear();
                            break;
                        }

                        sum *= 3;

                        stack.remove(stack.size()-1);
                        stack.add(sum.toString());
                    }
                }
            }

            cidx++;
        }

        int sum = 0;
        for(String ele : stack)
        {
            if(ele.equals("(") || ele.equals("["))// "((" 에 대한 예외처리
            {
                sum = 0;
                break;
            }
            sum += Integer.parseInt(ele);
        }

        System.out.println(sum);
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
            catch (IOException e)
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
