package 부분수열의합14225;
import java.io.*;
import java.util.*;

public class Main {


    static int count;//입력 받는 수열의 원소 개수
    static int[] inputArr;//입력받은 수열
    static HashSet<Integer> sumList = new HashSet<>();//부분집합의 합. 리스트

    public static void inputProcess()
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        try
        {
            count = Integer.parseInt(br.readLine());
            input = br.readLine().split(" ");
            inputArr = new int[count];
            for(int i = 0; i < count; ++i)
            {
                inputArr[i] = Integer.parseInt(input[i]);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {

        inputProcess();

        search(0, 0);

        for(int i = 0; i <= 20*100000; ++i)
        {
           if(false == sumList.contains(i))
           {
               System.out.println(i);
               break;
           }
        }

    }

    public static void search(int level, int sum)
    {
        if(level == count)
        {
            sumList.add(sum);
            return;
        }

        search(level+1, sum);
        search(level+1, sum + inputArr[level]);

    }
}
