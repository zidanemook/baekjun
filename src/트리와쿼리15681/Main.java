package 트리와쿼리15681;

import java.io.*;
import java.util.*;

public class Main
{
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static int N;
    static int R;
    static int Q;
    static int[] subCount;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        R = Integer.parseInt(input[1]);
        Q = Integer.parseInt(input[2]);

        for(int i = 0; i < N+1; ++i)
            tree.add(new ArrayList<>());

        for(int i = 0; i < N-1; ++i)
        {
            input = br.readLine().split(" ");

            int U = Integer.parseInt(input[0]);
            int V = Integer.parseInt(input[1]);

            tree.get(U).add(V);
            tree.get(V).add(U);
        }
        subCount = new int[N+1];
        recur_makeCount(0, R);


        for(int i = 0; i < Q; ++i)
        {
            int subRootId = Integer.parseInt(br.readLine());
            System.out.println(subCount[subRootId]);
        }
    }

    public static int recur_makeCount(int parent, int nodeId)
    {
        ArrayList<Integer> curNode = tree.get(nodeId);

        subCount[nodeId] = 1;

        for(int child : curNode)
        {
            if(child == parent)
                continue;
            subCount[nodeId] += recur_makeCount(nodeId, child);
        }

        return subCount[nodeId];
    }

}
