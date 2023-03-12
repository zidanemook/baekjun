package Queue_CustomArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static class MyQueue
    {
        int[] arrList = null;
        int size = 0;
        int front = -1;
        int back = -1;

        MyQueue(int size)
        {
            arrList = new int[size/4];
        }

        void push(int n)
        {
            if(back >= arrList.length-1)
            {
                int[] newArr = new int[arrList.length*2];
                System.arraycopy(arrList, 0, newArr, 0, arrList.length);
                arrList = newArr;
            }

            if(front == -1 && back == -1)
            {
                front++;
                back++;
            }
            else
                back++;

            arrList[back] = n;

            size++;
        }

        int pop()
        {
            if(1 == empty())
            {
                return -1;
            }

            int result = arrList[front];
            front++;
            size--;

            return result;
        }

        int size()
        {
            return size;
        }

        int empty()
        {
            return (size == 0) ? 1 : 0;
        }

        int front()
        {
            if(empty()==1)
                return -1;

            return arrList[front];
        }

        int back()
        {
            if(empty()==1)
                return -1;

            return arrList[back];
        }
    }


    public static void main(String[] args) {

        //Scanner scan = new Scanner(System.in);
        FastReader rd = new FastReader();

        StringBuilder ret = new StringBuilder();

        int inputCount;
        inputCount = rd.nextInt();

        int curCount = 0;

        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();

        MyQueue mq = new MyQueue(inputCount);


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
