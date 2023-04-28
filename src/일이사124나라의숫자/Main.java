package 일이사124나라의숫자;

import java.io.*;
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        System.out.println(solution(50000000));
    }

    static public String solution(int n)
    {
        String answer = "";

        ArrayList<Integer> arr = new ArrayList<>();

        while(true)
        {
            arr.add(n%3);
            n/=3;

            if(n < 3)
            {
                arr.add(n);
                break;
            }
        }

        int floor = 0;
        for(int i = 0; i < arr.size(); ++i)
        {
            if(floor > 0)
            {
                if(arr.get(i) == 0)
                {
                    arr.set(i, 2);
                }
                else if(arr.get(i) == 4)
                {
                    arr.set(i, 2);
                    floor--;
                }
                else
                {
                    arr.set(i, arr.get(i)-1);
                    floor--;
                }
            }

            if(arr.get(i) == 0 && i != (arr.size()-1))
            {
                floor++;
                arr.set(i, 4);
            }
        }
        Long temp = 0L;
        for(int i = arr.size()-1; i >= 0; --i)
        {
            temp *= 10;
            temp += arr.get(i);
        }

        answer = String.valueOf(temp);
        return answer;
    }
}
