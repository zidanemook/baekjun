package 주식11501;

import java.io.*;
import java.util.*;
public class Main
{
    static final int MAX = 10000;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; ++i)
        {
            int N = Integer.parseInt(br.readLine());//1000000
            int[] dayPrice = new int[N];//0~10000
            //PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            TreeMap<Integer, Integer> prices = new TreeMap<>(Collections.reverseOrder());//가격, 수량. 내림차순
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; ++j)
            {
                dayPrice[j] = Integer.parseInt(input[j]);

                if(prices.containsKey(dayPrice[j]))
                    prices.put(dayPrice[j], prices.get(dayPrice[j])+1);
                else
                    prices.put(dayPrice[j], 1);
            }

            int maxPrice = prices.firstKey();

            HashMap<Integer, Integer> stocks = new HashMap<>();//가격, 수량
            Long income = 0L;
            for(int j = 0; j < N; ++j)
            {
                int cur = dayPrice[j];

                if(prices.containsKey(cur))
                {
                    if(prices.get(cur) > 1)
                        prices.put(cur, prices.get(cur)-1);
                    else
                        prices.remove(cur);
                }


                if(cur > 0 &&  cur < maxPrice)//구입
                {
                    if(stocks.containsKey(cur))
                        stocks.put(cur, stocks.get(cur)+1);
                    else
                        stocks.put(cur, 1);
                }
                else if(cur == maxPrice)//가진거 전부 판매
                {
                    for (Integer price : stocks.keySet())
                    {
                        income += (maxPrice - price) * stocks.get(price);
                    }

                    stocks.clear();

                    if(prices.isEmpty() == false)
                        maxPrice = prices.firstKey();

                }

            }

            System.out.println(income);
        }
    }
}
