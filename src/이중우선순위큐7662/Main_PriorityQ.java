package 이중우선순위큐7662;

import java.io.*;
import java.util.*;

public class Main_PriorityQ {
    public static void main(String[] args) {

        FastReader fr = new FastReader();
        int T = Integer.parseInt(fr.nextLine());
        int K = 0;

        PriorityQueue<Integer> maxq = new PriorityQueue<>((a,b)-> b-a);
        PriorityQueue<Integer> minq = new PriorityQueue<>();

        ArrayList<Integer> combined = new ArrayList<>();

        for(int i = 0; i < T; ++i)
        {
            K = Integer.parseInt(fr.nextLine());

            int elementCnt = 0;
            for(int j = 0; j < K; ++j)
            {
                String[] operation = fr.nextLine().split(" ");
                if((operation[0].equals("D")) && (elementCnt!=0) )
                {
                    if(operation[1].equals("-1"))
                    {
                        minq.poll();
                        elementCnt--;
                    }
                    else if(operation[1].equals("1"))
                    {
                        maxq.poll();
                        elementCnt--;
                    }
                    if(elementCnt < 0)
                        elementCnt = 0;
                }
                else if(operation[0].equals("I"))
                {
                    elementCnt++;
                    maxq.add(Integer.parseInt(operation[1]));
                    minq.add(Integer.parseInt(operation[1]));
                }
            }

            if(elementCnt != 0)
            {
                Object[] maxArr = maxq.toArray();
                Object[] minArr = minq.toArray();

                Arrays.sort(maxArr);
                Arrays.sort(minArr);

                combined.clear();
                int maxIdx = 0;
                int minIdx = 0;
                while(true)
                {

                    if(((int)minArr[minIdx]) == ((int)maxArr[maxIdx]))
                    {
                        combined.add((Integer) minArr[minIdx]);

                        if(minIdx+1 < minArr.length)
                            minIdx++;
                        else
                            break;

                        if(maxIdx+1 < maxArr.length)
                            maxIdx++;
                        else
                            break;
                    }
                    else
                    {
                        if((Integer)maxArr[maxIdx] > (Integer)minArr[minIdx])
                        {
                            if(minIdx+1 < minArr.length)
                                minIdx++;
                            else
                                break;
                        }
                        else
                        {
                            if(maxIdx+1 < maxArr.length)
                                maxIdx++;
                            else
                                break;
                        }
                    }
                }

                //combined.sort((a,b)->(a-b));
            }

            if(elementCnt == 0)
                System.out.println("EMPTY");
            else {
                System.out.println(combined.get(combined.size()-1) + " " + combined.get(0));
            }

            maxq.clear();
            minq.clear();
        }


    }
}



