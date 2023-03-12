package 회의실배정1931;

import java.io.*;
import java.util.*;

class Meeting implements Comparable<Meeting>
{
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
        if(this.end != o.end)
            return (this.end < o.end) ? -1:1;
        else
            return (this.start <= o.start) ? -1:1;
    }
}

public class Main
{
    static BufferedReader br;

    static int N;

    static Meeting[] arr;

    static Stack<Meeting> stack = new Stack<>();

    public static void main(String[] args) throws IOException
    {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new Meeting[N];

        String[] input;

        for(int i = 0; i < N; ++i)
        {
            input = br.readLine().split(" ");

            arr[i] = new Meeting(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        Arrays.sort(arr);

        stack.push(arr[0]);
        for(int i = 1; i < arr.length; ++i)
        {
            if(stack.peek().end > arr[i].start)
                continue;

            stack.push(arr[i]);
        }

        System.out.println(stack.size());
    }
}
