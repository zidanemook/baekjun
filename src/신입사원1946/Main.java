package 신입사원1946;

import java.io.*;
import java.util.*;

class Applicant
{
    int docScore;
    int intvScore;

    public Applicant(int docScore, int intvScore) {
        this.docScore = docScore;
        this.intvScore = intvScore;
    }
}

public class Main
{
    static BufferedReader br;

    static int T;
    static int N;

    static ArrayList<Applicant> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException
    {
        br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        String[] input;
        int min;
        int cnt;
        for(int i = 0; i < T; ++i)
        {
            N = Integer.parseInt(br.readLine());


            for(int j = 0; j < N; ++j)
            {
                input = br.readLine().split(" ");
                list.add(new Applicant(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
            }

            list.sort((a,b) -> a.docScore < b.docScore ? -1 : 1);

            min = Integer.MAX_VALUE;
            cnt = 0;
            for(int j = 0; j < N; ++j)
            {
                if(min > list.get(j).intvScore)
                {
                    min = list.get(j).intvScore;
                    cnt++;
                }
            }

            sb.append(cnt);
            sb.append("\n");

            list.clear();
        }

        System.out.println(sb);
    }

}
