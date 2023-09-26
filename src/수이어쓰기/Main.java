package 수이어쓰기;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int can = 1;

        int i = 0;
        while(i < input.length())
        {
            String temp = String.valueOf(can);

            for(int j = 0; j < temp.length(); ++j)
            {

                int cur = input.charAt(i) - '0';
                if(temp.charAt(j)-'0' == cur)
                {
                    i++;
                    if(i >= input.length())
                        break;
                }
            }

            can++;
        }

        System.out.println(can-1); // 결과 출력
    }
}
