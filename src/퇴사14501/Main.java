package 퇴사14501;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] work = new int[N+2][2];

        String[] input;
        for(int i = 1; i <= N; ++i)
        {
            input = br.readLine().split(" ");
            work[i][0] = Integer.parseInt(input[0]);//T 시간
            work[i][1] = Integer.parseInt(input[1]);//P 돈
        }

        int[] money = new int[N+2];
        for(int i = N; i >= 1; --i)
        {
            if(i + work[i][0]-1 > N)//일하면 마무리를 못하는 경우
            {
                money[i] = money[i+1];
            }
            else if(work[i][0] == 1)//하루만에 끝나는 일
            {
                money[i] = money[i+1] + work[i][1];
            }
            else
            {
                //예를들어 총7일 기간(N=7). 오늘2일차 5일 걸리는일이면 6일차에 마무리하고 7일차 부터 일할 수 있다
                //그것은 2일차 임금 + 7~N 일차까지임금 합계  VS  3~N 일차까지 임금합계 의 대결이다!
                if(money[i + work[i][0]] + work[i][1] > money[i+1])
                {
                    money[i] = money[ i+ work[i][0]] + work[i][1];
                }
                else
                    money[i] = money[i+1];
            }
        }

        System.out.println(money[1]);
    }
}
