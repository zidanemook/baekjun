package NQueen9663;

import java.io.*;

public class Main
{
    static BufferedReader br;
    static int N;

    static boolean[] check;
    static int[] arr;

    static int ans = 0;

    //testcode
    //static int count = 0;

    public static void main(String[] args) throws IOException
    {
        inputProcess();
        search(0);

        System.out.println(ans);

        //testcode
        //System.out.println(count);
    }

    public static void inputProcess() throws IOException
    {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        check = new boolean[N];
    }

    public static void search(int depth)
    {
        if(depth == N)
        {
            ans++;
            return;
        }

        int curDownCross;
        int curUpCross;
        for(int i = 0; i < N; ++i)
        {
            curDownCross = depth-i;
            curUpCross = depth+i;
            if(false == check[i] && false == col(depth, curDownCross, curUpCross))
            {
                check[i] = true;
                arr[depth] = i;
                search(depth+1);
                check[i]= false;
            }
        }
    }

    public static boolean col(int depth, int curDownCross, int curUpCross)
    {
        //count++;//testcode

        int preDownCross;
        int preUpCross;

        boolean IsCol = false;
        for(int i = 0; i < depth; ++i)
        {
            preDownCross = i - arr[i];
            preUpCross = i + arr[i];

            if(curDownCross == preDownCross || curUpCross == preUpCross) {
                IsCol = true;
                break;
            }

            if(true == IsCol)
                break;
        }

        return IsCol;
    }
}
