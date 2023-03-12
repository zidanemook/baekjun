package Stack;


import java.util.Scanner;

public class Main {

    int[] array;
    int     top;

    Main(int n)
    {
        array = new int[n];
        top = -1;
    }

    void push(int n)
    {
        if(top == array.length-1)
        {
            int[] newArray = new int[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = null;
            array = newArray;
        }

        top++;
        array[top] = n;
    }

    int pop()
    {
        if(1 == empty())
        {
            return -1;
        }

        int result = array[top];
        top--;

        return result;
    }

    int size()
    {
        return top + 1;
    }

    int empty()
    {
        return (top == -1) ? 1 : 0;
    }

    int top()
    {
        if(1 == empty())
        {
            return -1;
        }
        return array[top];
    }

    public static boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        int count = 0;
        count = scan.nextInt();
        Main stack = new Main(count);

        StringBuilder builder = new StringBuilder();

        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        int idx = 0;
        while(idx < count && scan.hasNext())
        {
            first.setLength(0);
            first.insert(0, scan.next());

            if(first.toString().equals("push"))
            {
                second.setLength(0);
                second.insert(0, scan.next());
                int num = Integer.parseInt(second.toString());

                stack.push(num);
            }
            else if(first.toString().equals("pop"))
            {
                builder.append(stack.pop());
                builder.append("\n");
            }
            else if(first.toString().equals("size"))
            {
                builder.append(stack.size());
                builder.append("\n");
            }
            else if(first.toString().equals("empty"))
            {
                builder.append(stack.empty());
                builder.append("\n");
            }
            else if(first.toString().equals("top"))
            {
                builder.append(stack.top());
                builder.append("\n");
            }

            idx++;
        }

        System.out.println(builder.toString());
        scan.close();

    }
}
