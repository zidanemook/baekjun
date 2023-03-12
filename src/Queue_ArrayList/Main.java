package Queue_ArrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static class MyQueue
    {
        ArrayList<Integer> arrList;

        MyQueue()
        {
            arrList = new ArrayList<>();
        }

        void push(int n)
        {
            arrList.add(n);
        }

        int pop()
        {
            if(1 == empty())
            {
                return -1;
            }

            return  arrList.remove(0);
        }

        int size()
        {
            return arrList.size();
        }

        int empty()
        {
            return (arrList.isEmpty()) ? 1 : 0;
        }

        int front()
        {
            if(empty()==1)
                return -1;

            return arrList.get(0);
        }

        int back()
        {
            if(empty()==1)
                return -1;

            return arrList.get(arrList.size()-1);
        }
    }


    public static void main(String[] args) {


        FastReader rd = new FastReader();

        StringBuilder ret = new StringBuilder();

        int inputCount;
        inputCount = rd.nextInt();

        int curCount = 0;

        MyQueue mq = new MyQueue();


        while(curCount < inputCount)
        {

            String[] Line = rd.nextLine().split(" ");
            String cmd = Line[0];

            if(cmd.equals("push"))
            {
                int num = Integer.parseInt(Line[1]);
                mq.push(num);
            }
            else if(cmd.equals("pop"))
            {
                ret.append(mq.pop());
                ret.append("\n");
            }
            else if(cmd.equals("size"))
            {
                ret.append(mq.size());
                ret.append("\n");
            }
            else if(cmd.equals("empty"))
            {
                ret.append(mq.empty());
                ret.append("\n");
            }
            else if(cmd.equals("front"))
            {
                ret.append(mq.front());
                ret.append("\n");
            }
            else if(cmd.equals("back"))
            {
                ret.append(mq.back());
                ret.append("\n");
            }

            curCount++;

        }
        System.out.println(ret);

    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
