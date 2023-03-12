package 회문17609;

import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; ++i)
        {
            String temp = br.readLine();
            int ret = IsPal(temp, 0, temp.length()-1, 1);
            if(0 == ret)
                sb.append("0\n");
            else if( 1 == ret)
                sb.append("1\n");
            else
                sb.append("2\n");
        }

        System.out.println(sb);
    }

    public static int IsPal(String input, int l, int r, int chance)
    {
        int ret = 0;

        while(l <= r)
        {
            if(input.charAt(l) == input.charAt(r))
            {
                l++;
                r--;
            }
            else
            {
                if(chance == 1)
                {
                    boolean isPal = false;
                    if(input.charAt(l+1) == input.charAt(r))
                    {
                        chance--;
                        if(2 != IsPal(input, l+1, r, chance))
                            isPal = true;
                    }

                    if(input.charAt(l) == input.charAt(r-1))
                    {
                        chance--;
                        if(2 != IsPal(input, l, r-1, chance))
                            isPal = true;
                    }

                    if(false == isPal)
                    {
                        ret = 2;
                        break;
                    }
                    else
                    {
                        ret = 1;
                        break;
                    }
                }
                else
                {

                    ret = 2;
                    break;
                }
            }
        }

        return ret;
    }
}
