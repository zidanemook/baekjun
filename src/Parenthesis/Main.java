package Parenthesis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        StringBuilder ret = new StringBuilder();

        int inputCount = 0;
        inputCount = scan.nextInt();

        int curCount = 0;

        int parenthesisCnt = 0;
        while(curCount++ < inputCount && scan.hasNext())
        {
            sb.setLength(0);
            sb.append(scan.next());

            parenthesisCnt = 0;

            for(int i = 0; i < sb.length(); ++i)
            {
                if(sb.charAt(i) == '(')
                {
                    parenthesisCnt++;
                }
                else if(sb.charAt(i)== ')')
                {
                    if(parenthesisCnt == 0) {
                        parenthesisCnt--;
                        break;
                    }
                    parenthesisCnt--;
                }
            }

            if(parenthesisCnt == 0)
                ret.append("YES\n");
            else
                ret.append("NO\n");
        }

        System.out.println(ret.toString());
        scan.close();
    }
}
