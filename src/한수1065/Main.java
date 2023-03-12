package 한수1065;

import java.io.*;

public class Main {

    static int[] hansuArr = new int[1001];

    public static void main(String[] args) throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] tempArr = new int[4];

        int count = 0;//testcode

        for(int i = 1; i < hansuArr.length; ++i)//100~ 1000  약 4500 = 900 * 5
        {
            if(i < 100)
                hansuArr[i] = i;
            else
            {
                int copy = i;
                int j = 0;
                while(copy != 0)
                {
                    tempArr[j++] = copy % 10;
                    copy/=10;

                    count++;//testcode
                }

                int diff = 0;
                int diff2 = 0;
                boolean isHansu = true;
                for(int k = 0; k+1 < j;++k)
                {
                    diff2 = tempArr[k] - tempArr[k+1];

                    if(k == 0)
                    {
                        diff = diff2;
                    }
                    else if(diff == diff2)
                    {
                        diff = diff2;
                    }
                    else
                    {
                        isHansu = false;
                        break;
                    }

                    count++;//testcode
                }

                if(isHansu)
                    hansuArr[i] = hansuArr[i-1] + 1;
                else
                    hansuArr[i] = hansuArr[i-1];
            }

        }

        System.out.println(count);//testcode

        int N = Integer.parseInt(br.readLine());

        System.out.println(hansuArr[N]);
    }
}
