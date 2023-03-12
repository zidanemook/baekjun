package 이중우선순위큐7662;
import java.io.*;
import java.util.*;

class Data implements Comparable<Data>
{
    public int value;//숫자 값
    public int count;//숫자 중복개수 0이되면 인스턴스 삭제

    public Data(int value, int count) {
        this.value = value;
        this.count = count;
    }

    @Override
    public int compareTo(Data o) {
        int ret = 0;
        if(this.value < o.value)
            ret = -1;
        else if(this.value > o.value)
            ret = 1;

        return ret;
    }

    public Data set(int value, int count) {
        this.value = value;
        this.count = count;

        return this;
    }
}

public class Main {

    public static void main(String[] args)
    {
        FastReader fr = new FastReader();
        int T = Integer.parseInt(fr.nextLine());
        int K = 0;

        //TreeSet
        TreeSet<Data> ts = new TreeSet<>();

        Data tmp = new Data(0, 0);
        for(int i = 0; i < T; ++i)
        {
            K = Integer.parseInt(fr.nextLine());

            ts.clear();
            for (int j = 0; j < K; ++j)
            {
                String[] operation = fr.nextLine().split(" ");
                if((operation[0].equals("D")) && (ts.isEmpty()==false) )
                {
                    if(operation[1].equals("-1"))
                    {
                        ts.first().count--;
                        if(ts.first().count == 0)
                            ts.remove(ts.first());
                    }
                    else if(operation[1].equals("1"))
                    {
                        ts.last().count--;
                        if(ts.last().count == 0)
                            ts.remove(ts.last());
                    }

                }
                else if(operation[0].equals("I"))
                {
                   if(ts.contains(tmp.set(Integer.parseInt(operation[1]), 0)))//이미 숫자가 존재 한다면
                    {
                        Data find = ts.floor(tmp.set(Integer.parseInt(operation[1]),0));//찾아서. 현재 카운트값을 가져와야하기때문에.ceiling을 써도 된다
                        ts.remove(find);//삭제하고
                        ts.add(new Data(Integer.parseInt(operation[1]) ,find.count+1));//카운트 늘려서 넣기
                    }
                    else
                    {
                        ts.add(new Data(Integer.parseInt(operation[1]), 1));
                    }
                }
            }

            if(ts.isEmpty())
                System.out.println("EMPTY");
            else {
                System.out.println(ts.last().value + " " + ts.first().value);
            }
        }

    }
}

class FastReader
{
    BufferedReader br;
    StringTokenizer st;

    FastReader()
    {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String nextLine()
    {
        String str = "";
        try
        {
            str = br.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return str;
    }
}
