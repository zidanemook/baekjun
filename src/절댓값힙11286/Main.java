package 절댓값힙11286;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int inputCnt = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> max = new PriorityQueue<>((a,b)-> (b-a > 0) ? 1 : -1);//음수 처리
        PriorityQueue<Integer> min = new PriorityQueue<>();//양수 처리

        StringBuilder sb = new StringBuilder();

        int tmp = 0;
        for(int i = 0; i < inputCnt; ++i)
        {
            tmp = Integer.parseInt(br.readLine());
            if( 0 == tmp )
            {
                if((max.isEmpty() == false) && (min.isEmpty() == false))
                {
                    if( Math.abs(max.peek()) <= min.peek())
                    {
                        sb.append(max.poll()+"\n");
                    }
                    else if(Math.abs(max.peek()) > min.peek())
                    {
                        sb.append(min.poll()+"\n");
                    }
                }
                else if(max.isEmpty() == false)
                {
                    sb.append(max.poll()+"\n");
                }
                else if(min.isEmpty() == false)
                {
                    sb.append(min.poll()+"\n");
                }
                else
                {
                    sb.append("0"+"\n");
                }
            }
            else
            {
                if(tmp < 0)
                {
                    max.add(tmp);
                }
                else if(tmp > 0)
                {
                    min.add(tmp);
                }
            }
        }

        System.out.println(sb.toString());

    }

}
