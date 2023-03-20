package 잃어버린괄호1541;

import java.io.*;
import java.util.*;
public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Character> oper = new ArrayList<>();

        int idx = 0;
        boolean allsub = false;
        for (int i = 0; i < input.length(); ++i)
        {
            Character c = input.charAt(i);
            if(c == '+' || c == '-')
            {
                if(c == '-')
                    allsub = true;

                String num = input.substring(idx, i);
                arr.add(Integer.parseInt(num));

                idx = i+1;

                if(allsub)
                    oper.add('-');
                else
                    oper.add(c);
            }
            else if(i == input.length()-1)
            {
                String num = input.substring(idx, i+1);
                arr.add(Integer.parseInt(num));
            }
        }

        int sum = 0;

        for (int i = 0; i < arr.size(); ++i)
        {
            if(i > 0)
            {
                if(oper.get(i-1) == '+')
                    sum += arr.get(i);
                else
                    sum -= arr.get(i);
            }
            else
                sum = arr.get(i);

        }

        System.out.println(sum);
    }

}
