package 빈도정렬2910;

import java.io.*;
import java.util.*;

class Numset
{
    int num;
    int count;
    int order;

    public Numset(int num, int count, int order) {
        this.num = num;
        this.count = count;
        this.order = order;
    }
}

public class Main
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException
    {
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        HashMap<Integer, Numset> map = new HashMap<>();
        input = br.readLine().split(" ");

        int key;
        int order = 0;
        for(int i = 0; i < N; ++i)
        {
            key = Integer.parseInt(input[i]);
            if(false == map.containsKey(key))
                map.put(Integer.parseInt(input[i]), new Numset(key, 1, order++));
            else
            {
                map.get(key).count+=1;
            }
        }

        List<Map.Entry<Integer, Numset>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<Integer, Numset>>(){

            @Override
            public int compare(Map.Entry<Integer, Numset> o1, Map.Entry<Integer, Numset> o2) {
                if(o1.getValue().count == o2.getValue().count)
                    return o1.getValue().order < o2.getValue().order ? -1 : 1;
                else
                    return o1.getValue().count > o2.getValue().count ? -1 : 1;
            }

        });

        for(Map.Entry<Integer, Numset> entry : entryList)
        {
            for(int i = 0; i < entry.getValue().count; ++i)
            {
                System.out.print(entry.getKey() + " ");
            }

        }

    }
}
