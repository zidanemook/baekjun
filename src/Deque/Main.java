package Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static private class Node
    {
        public int data;
        public Node next;
        public Node prev;
        Node(int data, Node prev, Node next)
        {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    static class MyDeque
    {
        private Node head;
        private Node back;

        int size;
        MyDeque()
        {
            head = null;
            back = null;
            size = 0;
        }

        void push_front(int n)
        {
            if(head == null)
            {
                head = new Node(n, null, null);
                back = head;
                size = 1;
            }
            else
            {
                Node newNode = new Node(n, null, head);
                head.prev = newNode;
                head = newNode;
                size++;
            }
        }

        void push_back(int n)
        {
            if(head == null)
            {
                head = new Node(n, null, null);
                back = head;
                size = 1;
            }
            else
            {
                Node newNode = new Node(n, back, null);
                back.next = newNode;
                back = newNode;
                size++;
            }
        }
        int pop_front()
        {
            int result = -1;
            if(head != null)
            {
                result = head.data;

                if(head == back)
                {
                    head = null;
                    back = null;
                    size = 0;
                }
                else
                {
                    Node temp = head.next;
                    head.next = null;
                    head = temp;
                    head.prev = null;
                    size--;
                }
            }

            return result;
        }

        int pop_back()
        {
            int result = -1;
            if(back != null)
            {
                result = back.data;

                if(head == back)
                {
                    head = null;
                    back = null;
                    size = 0;
                }
                else
                {
                    Node temp = back.prev;
                    back.prev = null;
                    back = temp;
                    back.next = null;
                    size--;
                }
            }

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
            int result = -1;

            if(head != null)
                result = head.data;

            return result;
        }

        int back()
        {
            int result = -1;

            if(back != null)
                result = back.data;

            return result;
        }
    }

    public static void main(String[] args)
    {

        FastReader fr = new FastReader();
        MyDeque md = new MyDeque();
        StringBuilder sb = new StringBuilder();

        int cnt = fr.nextInt();

        String[] line;
        for(int i = 0; i < cnt; ++i)
        {
            line = fr.nextLine().split(" ");
            if(line[0].equals("push_front"))
            {
                md.push_front(Integer.parseInt(line[1]));
            }
            else if(line[0].equals("push_back"))
            {
                md.push_back(Integer.parseInt(line[1]));
            }
            else if(line[0].equals("pop_front"))
            {
                sb.append(md.pop_front()+"\n");
            }
            else if(line[0].equals("pop_back"))
            {
                sb.append(md.pop_back()+"\n");
            }
            else if(line[0].equals("size"))
            {
                sb.append(md.size()+"\n");
            }
            else if(line[0].equals("empty"))
            {
                sb.append(md.empty()+"\n");
            }
            else if(line[0].equals("front"))
            {
                sb.append(md.front()+"\n");
            }
            else if(line[0].equals("back"))
            {
                sb.append(md.back()+"\n");
            }
        }

        System.out.println(sb.toString());
    }

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
        public FastReader()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next()
        {
            while(st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str =  br.readLine();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }
    }
}
