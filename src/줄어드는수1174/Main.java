package 줄어드는수1174;

import java.io.*;
import java.util.*;

public class Main
{
    static BufferedReader br;
    static int N;

    static final int CNTNUM = 10;

    static int[] arr = new int[CNTNUM];
    static boolean[] checked = new boolean[CNTNUM];

    static int count;

    static ArrayList<Long> numList = new ArrayList<>();

    static Queue<Integer> que = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        inputProcess();

        search(0, 1);

        numList.sort( (a, b) -> (a < b) ? -1 : 1);

        if(N > 1023)
            System.out.println(-1);
        else
            System.out.println(numList.get(N-1));
    }

    public static void inputProcess() throws IOException
    {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
    }

    public static void search(int depth, int target)
    {
        if(target > 10)
            return;
        if(depth == target)
        {
            long temp = 0;
            for(int i = 0; i < target; ++i)
            {
                temp *= 10;
                temp += arr[i];
            }

            numList.add(temp);

            return;
        }

        for(int i = 0; i < 10; ++i)
        {
            if(checked[i] == false && (depth==0 || arr[depth-1] > i))
            {
                checked[i] = true;
                arr[depth] = i;
                search(depth+1, target);
                search(depth+1, target + 1);
                checked[i] = false;
            }

        }

    }
}
