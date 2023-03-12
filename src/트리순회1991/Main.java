package 트리순회1991;

import java.io.*;
import java.util.*;

public class Main
{
    private static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; ++i)
        {
            tree.add(new ArrayList<>());
        }

        String[] input = null;

        ArrayList<Integer> node = null;

        for(int i = 0; i < N; ++i)
        {
            input = br.readLine().split(" ");
            node = tree.get(input[0].charAt(0) - 'A');

            if(true == input[1].equals("."))
                node.add(-1);
            else
                node.add(input[1].charAt(0) - 'A');

            if(true == input[2].equals("."))
                node.add(-1);
            else
                node.add(input[2].charAt(0) - 'A');

        }

        recur_preorder(0);
        System.out.println(sb);
        sb.setLength(0);


        recur_midorder(0);
        System.out.println(sb);
        sb.setLength(0);

        recur_postorder(0);
        System.out.println(sb);
        sb.setLength(0);
    }

    public static void recur_preorder(Integer NodeId)
    {
        if(NodeId == -1)
            return;

        ArrayList<Integer> curNode = tree.get(NodeId);

        sb.append((char)(NodeId + 'A'));
        recur_preorder(curNode.get(0));


        recur_preorder(curNode.get(1));

    }

    public static void recur_midorder(Integer NodeId)
    {
        if(NodeId == -1)
            return;

        ArrayList<Integer> curNode = tree.get(NodeId);

        recur_midorder(curNode.get(0));

        sb.append((char)(NodeId + 'A'));

        recur_midorder(curNode.get(1));
    }

    public static void recur_postorder(Integer NodeId)
    {
        if(NodeId == -1)
            return;

        ArrayList<Integer> curNode = tree.get(NodeId);

        recur_postorder(curNode.get(0));

        recur_postorder(curNode.get(1));

        sb.append((char)(NodeId + 'A'));
    }
}
