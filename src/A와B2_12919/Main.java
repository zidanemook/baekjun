package A와B2_12919;

import java.io.*;
public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        StringBuilder sb = new StringBuilder();
        sb.append(T);

        if(search( sb, S))
            System.out.println(1);
        else
            System.out.println(0);
    }

    static boolean search( StringBuilder sb, String S)
    {
        if(S.length() == sb.length())
        {
            if(S.equals(sb.toString()))
                return true;
            return false;
        }

        boolean ret = false;

        StringBuilder sbcopy = new StringBuilder(sb);
        if('A' == sb.charAt(sb.length()-1))
        {
            sb.delete(sb.length()-1, sb.length());
            if(search(sb, S))
                return true;
        }

        if('B' == sbcopy.charAt(0))
        {
            sbcopy.delete(0, 1);
            sbcopy.reverse();
            if(search(sbcopy, S))
                return true;
        }

        return false;

    }
}
